package com.sirfilbido.bookofstarwars.ui.feature.character.listCharacter

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sirfilbido.bookofstarwars.R
import com.sirfilbido.bookofstarwars.domain.model.CharacterList
import com.sirfilbido.bookofstarwars.ui.components.RowLabelValue
import com.sirfilbido.bookofstarwars.ui.feature.character.listCharacter.components.ShimmerListCharacter
import com.sirfilbido.bookofstarwars.ui.navigation.Screen
import com.sirfilbido.bookofstarwars.ui.theme.CoruscantBlue
import com.sirfilbido.bookofstarwars.ui.theme.DroidYellow
import com.sirfilbido.bookofstarwars.ui.theme.GalaxyBlack
import com.sirfilbido.bookofstarwars.ui.theme.UnityWhite
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListCharacterScreen(navController: NavController) {

    val scope = rememberCoroutineScope()
    val viewModel = koinViewModel<ListCharacterViewModel>()
    val listCharacter by viewModel.listCharacterState.collectAsState()

    LaunchedEffect(viewModel) {
        scope.launch { viewModel.fetchCharacters() }
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
                        text = stringResource(id = R.string.list_character_toolbar_title),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        },
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            if (listCharacter.isEmpty()){
                items(10) {
                    ShimmerListCharacter()
                }
            }else{
                itemsIndexed(listCharacter){ position, _ ->
                    CardCharacter(position, listCharacter, navController)
                }
            }
        }
    }
}

@Composable
fun CardCharacter(
    position: Int,
    listCharacter: List<CharacterList>,
    navController: NavController,
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ), colors = CardDefaults.cardColors(
            containerColor = UnityWhite,
        ), modifier = Modifier
            .padding(10.dp)
            .clickable {
                navController.navigate(
                    Screen.DetailCharacterScreen.withArgs(
                        listCharacter[position].id,
                        listCharacter[position].name
                    )
                )
            }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                contentScale = ContentScale.Fit,
            )

            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                RowLabelValue(
                    stringResource(id = R.string.list_character_name),
                    listCharacter[position].name
                )
                RowLabelValue(
                    stringResource(id = R.string.list_character_birth_year),
                    listCharacter[position].birthYear
                )
                RowLabelValue(
                    stringResource(id = R.string.list_character_gender),
                    listCharacter[position].gender
                        ?: stringResource(id = R.string.list_character_undefined)
                )
            }
        }
    }
}
