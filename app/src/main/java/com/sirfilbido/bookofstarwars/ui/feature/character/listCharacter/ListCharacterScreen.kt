package com.sirfilbido.bookofstarwars.ui.feature.character.listCharacter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.sirfilbido.bookofstarwars.R
import com.sirfilbido.bookofstarwars.domain.model.CharacterList
import com.sirfilbido.bookofstarwars.ui.components.ElevatedCardBoSW
import com.sirfilbido.bookofstarwars.ui.components.RowLabelValue
import com.sirfilbido.bookofstarwars.ui.components.ScreenBoSW
import com.sirfilbido.bookofstarwars.ui.feature.character.listCharacter.components.ShimmerListCharacter
import com.sirfilbido.bookofstarwars.ui.navigation.Screen
import com.sirfilbido.bookofstarwars.utils.extensions.normalize
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListCharacterScreen(navController: NavController) {

    val viewModel = koinViewModel<ListCharacterViewModel>()
    val listCharacter = viewModel.listCharacterState.collectAsLazyPagingItems()

    ScreenBoSW(
        navController = navController,
        titleToolbar = stringResource(id = R.string.list_character_toolbar_title),
        isBackStack = false,
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(listCharacter.itemCount) { position ->
                    CardCharacter(listCharacter[position]!!, navController)
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
    listCharacter: CharacterList,
    navController: NavController,
) {
    ElevatedCardBoSW(
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

                Image(
                    painter = painterResource(id = resourceId),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(80.dp)
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
