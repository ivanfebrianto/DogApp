package com.example.ujianakhir.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.example.ujianakhir.PuppyListItem
import com.example.ujianakhir.data.DataProvider
import com.example.ujianakhir.data.model.Puppy

@Composable
fun BarkHomeContent(navigateToProfile :(Puppy)->Unit){
    val puppies = remember { DataProvider.puppyList}
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ){
        items(
            items = puppies,
            itemContent = {
                PuppyListItem(puppy = it,navigateToProfile)
            }
        )
    }
}