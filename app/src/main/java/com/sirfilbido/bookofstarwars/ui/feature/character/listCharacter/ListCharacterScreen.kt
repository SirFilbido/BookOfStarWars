package com.sirfilbido.bookofstarwars.ui.feature.character.listCharacter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.sirfilbido.bookofstarwars.R
import com.sirfilbido.bookofstarwars.domain.model.CharacterList
import com.sirfilbido.bookofstarwars.ui.components.box.BoSWBoxFrameAvatar
import com.sirfilbido.bookofstarwars.ui.components.card.BoSWElevatedCard
import com.sirfilbido.bookofstarwars.ui.components.row.RowLabelValue
import com.sirfilbido.bookofstarwars.ui.components.screen.BoSWScreen
import com.sirfilbido.bookofstarwars.ui.components.screen.ScreenPreview
import com.sirfilbido.bookofstarwars.ui.components.shimmer.ShimmerListCharacter
import com.sirfilbido.bookofstarwars.ui.navigation.Screen
import com.sirfilbido.bookofstarwars.utils.extensions.normalize
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListCharacterScreen(navController: NavController) {

    val viewModel = koinViewModel<ListCharacterViewModel>()
    val listCharacter = viewModel.listCharacterState.collectAsLazyPagingItems()

    BoSWScreen(
        navController = navController,
        titleToolbar = stringResource(id = R.string.list_character_toolbar_title),
        isBackStack = false,
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(listCharacter.itemCount) { position ->
                    listCharacter[position]?.let { CardCharacter(navController, it) }
                }

                listCharacter.apply {
                    when {

                        loadState.refresh is LoadState.Loading -> {
                            items(10) {
                                ShimmerListCharacter()
                            }
                        }

                        loadState.append is LoadState.Loading -> {
                            items(10) {
                                ShimmerListCharacter()
                            }
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun CardCharacter(
    navController: NavController,
    listCharacter: CharacterList,
) {
    BoSWElevatedCard(
        clickable = {
            navController.navigate(
                Screen.DetailCharacterScreen.withArgs(
                    listCharacter.id,
                    listCharacter.name
                )
            )
        },
        content = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val context = LocalContext.current
                val resourceId = context.resources.getIdentifier(
                    "character_" + listCharacter.id,
                    "drawable",
                    context.packageName
                )

                BoSWBoxFrameAvatar(
                    content = {
                        Image(
                            painter = painterResource(id = resourceId),
                            contentDescription = null,
                            contentScale = ContentScale.Inside,
                            modifier = Modifier.height(100.dp)
                        )
                    }
                )

                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    RowLabelValue(
                        stringResource(id = R.string.list_character_name),
                        listCharacter.name
                    )
                    RowLabelValue(
                        stringResource(id = R.string.list_character_birth_year),
                        listCharacter.birthYear.normalize()
                    )
                    RowLabelValue(
                        stringResource(id = R.string.list_character_gender),
                        listCharacter.gender.normalize()
                    )
                }
            }
        }
    )
}

@Preview
@Composable
fun ListCharacterScreenPreview() {
    ScreenPreview {
        ListCharacterScreen(navController = rememberNavController())
    }
}