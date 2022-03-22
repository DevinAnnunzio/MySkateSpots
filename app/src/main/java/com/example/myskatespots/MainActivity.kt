package com.example.myskatespots

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myskatespots.MapAdapter.OnClickListener
import com.example.myskatespots.models.Place
import com.example.myskatespots.models.UserMap

private const val TAG = "Main Activity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mapRV = findViewById<RecyclerView>(R.id.mapRV)
        val userMaps = generateSampleData()

        mapRV.layoutManager = LinearLayoutManager(this)

        mapRV.adapter = MapAdapter(this, userMaps, object: OnClickListener{
            override fun onItemClick(position: Int) {
                Log.i(TAG, "Item clicked in Main $position")
            }

        })

    }

    private fun generateSampleData(): List<UserMap> {
        return listOf(
            UserMap("Dummy data for testing",
                listOf(
                    Place("Seventh Street Truck Park, MN, USA", "Food place", 44.943592, -93.103584),
                    Place("Hard Rock Cafe New York, USA", "Hard rock", 40.757046, -73.986732),
                    Place("Jay Bees Nuts, Jersey City, NJ, USA", "Go nuts", 40.679855, -74.089859),
                    Place("Nathan's Famous, NY, USA", "Mr nathans", 40.575195, -73.981728),
                    Place("Joe's Pizza, NY, USA", "Good pizza", 40.730522, -74.002205)
                )
            )
        )
}
}
