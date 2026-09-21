package com.example.wishlist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: WishlistAdapter
    private val wishlistItems = mutableListOf(
        WishlistItem("Stanley Quencher Tumbler", "45.00", "https://www.stanley1913.com"),
        WishlistItem("Dyson Airwrap", "599.99", "https://www.dyson.com"),
        WishlistItem("Lululemon Align Leggings", "98.00", "https://www.lululemon.com"),
        WishlistItem("Apple AirPods Pro", "249.00", "https://www.apple.com"),
        WishlistItem("Kindle Paperwhite", "139.99", "https://www.amazon.com"),
        WishlistItem("Sephora Favorites Set", "65.00", "https://www.sephora.com"),
        WishlistItem("Nike Air Force 1", "110.00", "https://www.nike.com"),
        WishlistItem("Anthropologie Throw Blanket", "88.00", "https://www.anthropologie.com"),
        WishlistItem("Charlotte Tilbury Pillow Talk Set", "75.00", "https://www.charlottetilbury.com"),
        WishlistItem("Herschel Weekender Bag", "130.00", "https://www.herschel.com"),
        WishlistItem("Aesop Hand Balm", "32.00", "https://www.aesop.com"),
        WishlistItem("Rare Beauty Blush", "23.00", "https://www.rarebeauty.com"),
        WishlistItem("Away Carry-On Suitcase", "295.00", "https://www.awaytravel.com")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvWishlist = findViewById<RecyclerView>(R.id.rvWishlist)
        val etName = findViewById<EditText>(R.id.etName)
        val etPrice = findViewById<EditText>(R.id.etPrice)
        val etUrl = findViewById<EditText>(R.id.etUrl)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        adapter = WishlistAdapter(wishlistItems)
        rvWishlist.layoutManager = LinearLayoutManager(this)
        rvWishlist.adapter = adapter

        btnSubmit.setOnClickListener {
            val name = etName.text.toString().trim()
            val price = etPrice.text.toString().trim()
            val url = etUrl.text.toString().trim()

            if (name.isEmpty() || price.isEmpty() || url.isEmpty()) {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            adapter.addItem(WishlistItem(name, price, url))

            etName.text.clear()
            etPrice.text.clear()
            etUrl.text.clear()
        }
    }
}