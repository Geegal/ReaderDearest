package com.example.firebasestorage.ui.theme.screens.books


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firebasestorage.R
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.firebasestorage.ui.theme.FirebasestorageTheme
import com.example.firebasestorage.data.BookViewModel
import com.example.firebasestorage.models.Book

@Composable
fun ViewProductsScreen(navController:NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var bookRepository = BookViewModel(navController, context)


        val emptyBookState = remember { mutableStateOf(Book("","","","","")) }
        var emptyBooksListState = remember { mutableStateListOf<Book>() }

        var books = bookRepository.allBooks(emptyBookState, emptyBooksListState)


        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All products",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(books){
                    ProductItem(
                        name = it.name,
                        genre = it.genre,
                        price = it.price,
                        id = it.id,
                        navController = navController,
                        bookRepository = bookRepository,
                        bookImage = it.imageUrl
                    )
                }
            }
        }
    }
}


@Composable
fun ProductItem(name:String, genre:String, price:String, id:String,
                navController:NavHostController,
                bookRepository:BookViewModel, bookImage:String) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .paint(
            painterResource(id = R.drawable.wallpaper4),
            contentScale = ContentScale.FillBounds
        )
        .verticalScroll(rememberScrollState())) {
        Text(
            text = name,
            fontWeight = FontWeight.Bold
        )
        Text(text = genre)
        Text(text = price)
        Image(
            painter = rememberAsyncImagePainter(bookImage),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )
        Button(onClick = {
            bookRepository.deleteBook(id)
        }) {
            Text(text = "Delete")
        }
        val mContext = LocalContext.current
        Button(onClick = {
            val simToolKitLaunchIntent =
                mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { mContext.startActivity(it) }
        }) {
            Text(text = "pay")
        }
//        Button(onClick = {
//            navController.navigate(ROUTE_UPDATE_PRODUCTS+"/$id")
//        }) {
//            Text(text = "Update")
//        }
    }
}





@Composable
@Preview(showBackground = true)
fun ViewProductsScreenPreview(){
   FirebasestorageTheme {
        ViewProductsScreen(navController = rememberNavController())
    }
}