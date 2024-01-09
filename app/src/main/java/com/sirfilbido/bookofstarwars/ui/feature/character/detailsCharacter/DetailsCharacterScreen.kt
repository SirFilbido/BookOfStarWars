package com.sirfilbido.bookofstarwars.ui.feature.character.detailsCharacter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.sirfilbido.bookofstarwars.R
import com.sirfilbido.bookofstarwars.ui.components.box.BoSWBoxFrameAvatar
import com.sirfilbido.bookofstarwars.ui.components.card.BoSWElevatedCard
import com.sirfilbido.bookofstarwars.ui.components.row.RowLabelValue
import com.sirfilbido.bookofstarwars.ui.components.screen.BoSWScreen
import com.sirfilbido.bookofstarwars.ui.components.screen.ScreenPreview
import com.sirfilbido.bookofstarwars.ui.components.shimmer.ShimmerDetailsCharacter
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

    BoSWScreen(
        navController = navController,
        titleToolbar = name,
        isLoading = character.id == 0,
        loadingContent = { ShimmerDetailsCharacter() },
        content = {
            BoSWElevatedCard {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    val context = LocalContext.current
                    val resourceId = context.resources.getIdentifier(
                        "character_" + character.id,
                        "drawable",
                        context.packageName
                    )

                    BoSWBoxFrameAvatar(
                        content = {
                            AsyncImage(
                                model = resourceId,
                                contentDescription = "",
                                contentScale = ContentScale.Inside,
                                modifier = Modifier.height(160.dp)
                            )
                        }
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
    )
}

@Preview
@Composable
fun ListCharacterScreenPreview() {
    ScreenPreview {
        DetailCharacterScreen(navController = rememberNavController(), 1, "C-3PO")
    }
}
