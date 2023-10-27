package com.sirfilbido.bookofstarwars.ui.feature.character.detailsCharacter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sirfilbido.bookofstarwars.R
import com.sirfilbido.bookofstarwars.domain.model.Character
import com.sirfilbido.bookofstarwars.ui.components.RowLabelValue
import com.sirfilbido.bookofstarwars.ui.components.ScreenBoSW
import com.sirfilbido.bookofstarwars.ui.feature.character.detailsCharacter.components.ShimmerDetailsCharacter
import com.sirfilbido.bookofstarwars.ui.theme.UnityWhite
import com.sirfilbido.bookofstarwars.utils.extensions.formatAsSentence
import com.sirfilbido.bookofstarwars.utils.extensions.formatHeight
import com.sirfilbido.bookofstarwars.utils.extensions.formatMass
import com.sirfilbido.bookofstarwars.utils.extensions.isNotNA
import com.sirfilbido.bookofstarwars.utils.extensions.normalize
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailCharacterScreen(navController: NavController, id: Int, name: String) {

    val scope = rememberCoroutineScope()
    val viewModel = koinViewModel<DetailsCharacterViewModel>()
    val character by viewModel.characterState.collectAsState()

    LaunchedEffect(viewModel) {
        scope.launch { viewModel.fetchCharacter(id) }
    }

    ScreenBoSW(
        navController = navController,
        titleToolbar = name,
        content = {
            if (character.id == 0) {
                ShimmerDetailsCharacter()
            } else {
                CardCharacter(character = character)
            }
        }
    )
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
                    label = stringResource(id = R.string.details_character_birth_year),
                    value = character.birthYear.normalize()
                )
                RowLabelValue(
                    label = stringResource(id = R.string.details_character_gender),
                    value = character.gender.normalize(),
                    isShow = character.gender.isNotNA()
                )
                RowLabelValue(
                    label = stringResource(id = R.string.details_character_homeworld),
                    value = character.homeworld.name
                )
                RowLabelValue(
                    label = stringResource(id = R.string.details_character_mass),
                    value = character.mass.formatMass()
                )
                RowLabelValue(
                    label = stringResource(id = R.string.details_character_height),
                    value = character.height.formatHeight()
                )
                RowLabelValue(
                    label = stringResource(id = R.string.details_character_skinColor),
                    value = character.skinColor.normalize()
                )
                RowLabelValue(
                    label = stringResource(id = R.string.details_character_hairColor),
                    value = character.hairColor.formatAsSentence(),
                    isShow = character.hairColor.formatAsSentence().isNotNA()
                )
                RowLabelValue(
                    label = stringResource(id = R.string.details_character_eyeColor),
                    value = character.eyeColor.normalize()
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
