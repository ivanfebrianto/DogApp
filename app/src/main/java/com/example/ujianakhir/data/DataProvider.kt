package com.example.ujianakhir.data

import com.example.ujianakhir.R
import com.example.ujianakhir.data.model.Puppy


object DataProvider {

    val puppy =
        Puppy(
            id = 1,
            title = "Monty",
            sex = "Jantan",
            age = 14,
            description = "Friendly, cocok dengan anak kecil dan suka makan daging ayam",
            puppyImageId = R.drawable.p1
        )

    val puppyList = listOf(
        puppy,
        Puppy(
            id = 2,
            title = "Jubilee",
            sex = "Betina",
            age = 6,
            description = "Jubilee sangat menyukai pelukan hangat",
            puppyImageId = R.drawable.p2
        ),
        Puppy(
            id = 3,
            title = "Beezy",
            sex = "Jantan",
            age = 8,
            description = "Beezy sangat pintar dalam memilih warna.",
            puppyImageId = R.drawable.p3
        ),
        Puppy(
            id = 4,
            title = "Mochi",
            sex = "Jantan",
            age = 10,
            description = "Mochi adalah partner yang sempurna sebagai teman curhat.",
            puppyImageId = R.drawable.p4
        ),
        Puppy(
            id = 5,
            title = "Brewery",
            sex = "Betina",
            age = 12,
            description = "Brewery sangat suka bermain fetch.",
            puppyImageId = R.drawable.p5
        ),
        Puppy(
            id = 6,
            title = "Lucy",
            sex = "Betina",
            age = 8,
            description = "Lucy sangat menyukai air dan sedikit melankolis",
            puppyImageId = R.drawable.p6
        ),
        Puppy(
            id = 7,
            title = "Astro",
            sex = "Jantan",
            age = 10,
            description = "Astro adalah anjing yang sangat aktif!",
            puppyImageId = R.drawable.p7
        ),
        Puppy(
            id = 8,
            title = "Boo",
            sex = "Betina",
            age = 9,
            description = "Boo memiliki charm yang tidak dimiliki anjing lain",
            puppyImageId = R.drawable.p8
        ),
        Puppy(
            id = 9,
            title = "Pippa",
            sex = "Jantan",
            age = 7,
            description = "Pippa sangat menyukai jalan-jalan di Taman bermain",
            puppyImageId = R.drawable.p9
        ),
        Puppy(
            id = 10,
            title = "Coco",
            sex = "Betina",
            age = 10,
            description = "Coco sangat suka dimanja.",
            puppyImageId = R.drawable.p10
        ),
        Puppy(
            id = 11,
            title = "Brody",
            sex = "Jantan",
            age = 13,
            description = "Brody sangat suka dengan fashion yang stylish!.",
            puppyImageId = R.drawable.p11
        ),
        Puppy(
            id = 12,
            title = "Stella",
            sex = "Betina",
            age = 14,
            description = "Stella adalah anjing loyal yang bisa membuat hari-harimu lebih bahagia.",
            puppyImageId = R.drawable.p12
        ),
    )
}