package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)

        val foodName = intent.getStringExtra("FOOD_NAME")
        val servings = intent.getStringExtra("SERVINGS")
        val orderingName = intent.getStringExtra("ORDERING_NAME")
        val note = intent.getStringExtra("NOTE")

        val foodnameView = findViewById<TextView>(R.id.foodname_view)
        val numberServeView = findViewById<TextView>(R.id.serving_view)
        val orderNameView = findViewById<TextView>(R.id.ordername_view)
        val noteView = findViewById<TextView>(R.id.note_view)
        val backButton = findViewById<Button>(R.id.backtoMenu)

        foodnameView.text = "Food Name: $foodName"
        numberServeView.text = "Servings: $servings"
        orderNameView.text = "Ordering Name: $orderingName"
        noteView.text = "Note: $note"

        backButton.setOnClickListener {
            val intent = Intent(this, ListFoodActivity::class.java)
            intent.putExtra("USERNAME","fathir")
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}