package com.kim.thehistoryapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    data class Celebrity(val name: String, val age: Int, val description: String)

    // Create a list of 10 celebrities
    private val celebrities = listOf(
        Celebrity("Julius Caesar", 55, "Julius Caesar, the renowned Roman general and statesman, met his demise at the age of 55. His assassination marked the end of the Roman Republic and the beginning of the Roman Empire. Examining Caesar's age at death offers insights into the tumultuous political landscape of ancient Rome and the perils faced by those in positions of power."),
        Celebrity("Cleopatra VII", 39, "Cleopatra VII, the last active ruler of the Ptolemaic Kingdom of Egypt, died at the age of 39. Her death, often associated with the fall of Egypt to the forces of Octavian (later Emperor Augustus), symbolizes the end of an era for Egypt and the beginning of Roman hegemony in the region."),
        Celebrity("Leonardo da Vinci", 67, "Leonardo da Vinci, the epitome of the Renaissance polymath, passed away at the age of 67. His multifaceted genius encompassed art, science, engineering, and invention. Exploring da Vinci's age at death offers insights into the longevity and productivity of individuals during the Renaissance period, as well as the flourishing of artistic and intellectual endeavors."),
        Celebrity("William Shakespeare", 52, "William Shakespeare, the unparalleled playwright and poet of the Elizabethan era, died at the age of 52. His legacy continues to shape literature and drama to this day. Examining Shakespeare's age at death provides perspective on the average lifespan and cultural milieu of the early modern period in England."),
        Celebrity("Marie Curie", 66, "Marie Curie, the pioneering physicist and chemist, passed away at the age of 66. Her groundbreaking research on radioactivity earned her two Nobel Prizes and revolutionized our understanding of the atomic structure. Curie's age at death highlights the challenges faced by trailblazing women in the male-dominated scientific community of the early 20th century."),
        Celebrity("Mahatma Gandhi", 78, "Mahatma Gandhi, the preeminent leader of India's independence movement, was assassinated at the age of 78. His philosophy of nonviolent resistance continues to inspire movements for civil rights and social justice worldwide. Gandhi's age at death reflects his enduring commitment to his principles and the profound impact of his activism."),
        Celebrity("Albert Einstein", 76, "Albert Einstein, the revolutionary physicist who formulated the theory of relativity, died at the age of 76. His contributions to science reshaped our understanding of the universe and laid the groundwork for modern physics. Exploring Einstein's age at death offers insights into the intellectual vitality and longevity of exceptional minds in the 20th century."),
        Celebrity("Frida Kahlo", 47, "Frida Kahlo, the iconic Mexican artist known for her vibrant self-portraits and uncompromising expression of identity and suffering, passed away at the age of 47. Her art continues to resonate with audiences worldwide, transcending cultural and temporal boundaries. Kahlo's age at death underscores the profound impact of physical and emotional trauma on her life and work."),
        Celebrity("Martin Luther King Jr", 39, "Martin Luther King Jr., the civil rights leader and advocate for racial equality, was assassinated at the age of 39. His leadership during the American civil rights movement transformed the landscape of race relations and inspired generations to strive for justice and equality. King's age at death serves as a poignant reminder of the sacrifices made in the pursuit of social change."),
        Celebrity("Steve Jobs", 56, "Steve Jobs, the visionary co-founder of Apple Inc. and pioneer of the digital age, died at the age of 56. His innovative products revolutionized the technology industry and transformed the way we interact with computers, music, and communication. Jobs' age at death reflects the impact of his relentless pursuit of excellence and the challenges of balancing creativity with health.")
    )

    private lateinit var enterAgeText: TextView
    private lateinit var userAgeBtn: Button
    private lateinit var celebNameTextView: TextView
    private lateinit var celebInfoTextview: TextView
    private lateinit var ClearBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        enterAgeText = findViewById(R.id.EnterAgeText)
        ClearBtn = findViewById(R.id.ClearBtn)
        userAgeBtn = findViewById(R.id.UserAgeBtn)
        celebNameTextView = findViewById(R.id.CelebNameTextView)
        celebInfoTextview = findViewById(R.id.CelebInfoTextview)


        userAgeBtn.setOnClickListener {
            val ageStr = enterAgeText.text.toString()
            if (ageStr.isNotEmpty()) {
                try {
                    val userAge = ageStr.toInt()
                    val foundCeleb = celebrities.find {
                        it.age == userAge
                    }
                    Toast.makeText(this, "Celebrity match found", Toast.LENGTH_SHORT).show()
                    if (foundCeleb != null) {
                        celebNameTextView.text = foundCeleb.name
                        celebInfoTextview.text = foundCeleb.description
                    } else {
                        celebNameTextView.text = ""
                        celebInfoTextview.text = ""
                    }
                } catch (e: NumberFormatException) {
                    celebNameTextView.text = ""
                    celebInfoTextview.text = ""
                    Toast.makeText(this, "Oops! You tried to enter a non-integer value. Please enter a valid age.", Toast.LENGTH_SHORT).show()
                }
            }
        }


        ClearBtn.setOnClickListener {

         enterAgeText.text = null;
            celebNameTextView.text = null;
            celebInfoTextview.text = null;
        }

    }

}
