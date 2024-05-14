package com.example.firebasestorage.ui.theme.screens.home

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firebasestorage.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.firebasestorage.ui.theme.Purple200


@Composable
fun HomeScreen2(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple200),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val mContext = LocalContext.current

        Image(
            painter = painterResource(id = R.drawable.ggg1),
            contentDescription = "water",
            modifier = Modifier
                .size(300.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(15.dp))
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Dearest Reader...",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 30.sp,
        )
        Spacer(modifier = Modifier.height(35.dp))
// Text on the fundamentals of the app******
        Text(text = "Wherever thou art be thy we shall endeavour,")
        Text(text = "to grant thy wish of all books,")
        Text(text = "Thou shall want to obtain.")

        Spacer(modifier = Modifier.height(35.dp))

        Button(
            onClick = {  },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(Purple200),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
        ) {
            Text(text = "Books")

        }
    }



}

@Preview
@Composable
fun HomeScreen2Preview() {
    HomeScreen2(rememberNavController())
}