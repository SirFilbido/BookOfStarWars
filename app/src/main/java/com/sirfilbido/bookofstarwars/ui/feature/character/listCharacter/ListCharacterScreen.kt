package com.sirfilbido.bookofstarwars.ui.feature.character.listCharacter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sirfilbido.bookofstarwars.R
import com.sirfilbido.bookofstarwars.domain.model.CharacterList
import com.sirfilbido.bookofstarwars.ui.components.ElevatedCardBoSW
import com.sirfilbido.bookofstarwars.ui.components.RowLabelValue
import com.sirfilbido.bookofstarwars.ui.components.ScreenBoSW
import com.sirfilbido.bookofstarwars.ui.feature.character.listCharacter.components.ShimmerListCharacter
import com.sirfilbido.bookofstarwars.ui.navigation.Screen
import com.sirfilbido.bookofstarwars.utils.extensions.normalize
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListCharacterScreen(navController: NavController) {

    val scope = rememberCoroutineScope()
    val viewModel = koinViewModel<ListCharacterViewModel>()
    val listCharacter by viewModel.listCharacterState.collectAsState()

    val scrollState = rememberLazyListState()
    val visibleItemsInfo = scrollState.layoutInfo.visibleItemsInfo
    val isScrolledToEnd = visibleItemsInfo.any { it.index == listCharacter.size - 1 }


    LaunchedEffect(viewModel) {
        scope.launch { viewModel.fetchCharacters() }
    }

    ScreenBoSW(
        navController = navController,
        titleToolbar = stringResource(id = R.string.list_character_toolbar_title),
        isBackStack = false,
        content = {
            LazyColumn(
                state = scrollState,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                if (listCharacter.isEmpty()) {
                    items(10) {
                        ShimmerListCharacter()
                    }
                } else {
                    itemsIndexed(listCharacter) { position, _ ->
                        CardCharacter(position, listCharacter, navController)
                    }

                    if (isScrolledToEnd && !viewModel.isLoadingNextPage) {
                        // Carregue a próxima página se estiver visível e não estiver carregando
                        viewModel.loadNextPage()
                    }
                }

            }
        }
    )
}

@Composable
fun CardCharacter(
    position: Int,
    listCharacter: List<CharacterList>,
    navController: NavController,
) {
    ElevatedCardBoSW(
        clickable = {
            navController.navigate(
                Screen.DetailCharacterScreen.withArgs(
                    listCharacter[position].id,
                    listCharacter[position].name
                )
            )
        },
        content = {
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
                        listCharacter[position].birthYear.normalize()
                    )
                    RowLabelValue(
                        stringResource(id = R.string.list_character_gender),
                        listCharacter[position].gender.normalize()
                    )
                }
            }
        }
    )
}
