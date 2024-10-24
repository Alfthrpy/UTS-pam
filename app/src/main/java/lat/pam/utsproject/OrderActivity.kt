package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        val orderButton = findViewById<Button>(R.id.btnOrder)
        val foodName = findViewById<EditText>(R.id.etFoodName)
        val numberServe = findViewById<EditText>(R.id.etServings)
        val orderingName = findViewById<EditText>(R.id.etName)
        val note = findViewById<EditText>(R.id.etNotes)

        orderButton.setOnClickListener {
            val foodNameValue = foodName.text.toString()
            val numberServeValue = numberServe.text.toString()
            val orderingNameValue = orderingName.text.toString()
            val noteValue = note.text.toString()

            val intent = Intent(this, ConfirmationActivity::class.java).apply {
                putExtra("FOOD_NAME", foodNameValue)
                putExtra("SERVINGS", numberServeValue)
                putExtra("ORDERING_NAME", orderingNameValue)
                putExtra("NOTE", noteValue)
            }

            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}