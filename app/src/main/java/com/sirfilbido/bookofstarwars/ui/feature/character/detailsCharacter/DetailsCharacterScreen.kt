package com.sirfilbido.bookofstarwars.ui.feature.character.detailsCharacter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sirfilbido.bookofstarwars.R
import com.sirfilbido.bookofstarwars.domain.model.Character
import com.sirfilbido.bookofstarwars.ui.components.RowLabelValue
import com.sirfilbido.bookofstarwars.ui.feature.character.detailsCharacter.components.ShimmerDetailsCharacter
import com.sirfilbido.bookofstarwars.ui.theme.CoruscantBlue
import com.sirfilbido.bookofstarwars.ui.theme.DroidYellow
import com.sirfilbido.bookofstarwars.ui.theme.GalaxyBlack
import com.sirfilbido.bookofstarwars.ui.theme.UnityWhite
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailCharacterScreen(navController: NavController, id: Int, name: String) {

    val scope = rememberCoroutineScope()
    val viewModel = koinViewModel<DetailsCharacterViewModel>()
    val character by viewModel.characterState.collectAsState()

    LaunchedEffect(viewModel) {
        scope.launch { viewModel.fetchCharacter(id) }
    }

    Scaffold(
        containerColor = CoruscantBlue,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = GalaxyBlack,
                    titleContentColor = DroidYellow
                ),
                title = {
                    Text(
                        text = name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            tint = UnityWhite,
                            contentDescription = null
                        )
                    }
                },
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            if (character.id == 0) {
                ShimmerDetailsCharacter()
            } else {
                CardCharacter(character = character)
            }
        }
    }
}

@Composable
fun CardCharacter(character: Character) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ), colors = CardDefaults.cardColors(
            containerColor = UnityWhite,
        ), modifier = Modifier.padding(10.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 20.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                contentScale = ContentScale.Fit,
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                RowLabelValue(
                    stringResource(id = R.string.details_character_birth_year),
                    character.birthYear
                )
                RowLabelValue(
                    stringResource(id = R.string.details_character_gender),
                    character.gender ?: "Error"
                )
                RowLabelValue(
                    stringResource(id = R.string.details_character_homeworld),
                    character.homeworld?.name ?: "Error"
                )
                RowLabelValue(
                    stringResource(id = R.string.details_character_mass),
                    character.mass.toString()
                )
                RowLabelValue(
                    stringResource(id = R.string.details_character_height),
                    character.height.toString()
                )
                RowLabelValue(
                    stringResource(id = R.string.details_character_skinColor),
                    character.skinColor
                )
                RowLabelValue(
                    stringResource(id = R.string.details_character_hairColor),
                    character.hairColor.toString()
                )
                RowLabelValue(
                    stringResource(id = R.string.details_character_eyeColor),
                    character.eyeColor
                )
            }
        }
    }
}

@Preview
@Composable
private fun MyViewPreview() {
    CardCharacter(Character())
}
