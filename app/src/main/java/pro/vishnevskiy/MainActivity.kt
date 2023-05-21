package pro.vishnevskiy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pro.vishnevskiy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var beam: Beam
    private var isLight = false
    private lateinit var collectStatistic: CollectStatistic


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        beam = Beam(this)

        setOnClickListeners()
        collectStatistic = CollectStatistic(this)
        collectStatistic.pushDataToFirebaseOnCreate()

    }

    private fun setOnClickListeners() {

        binding.buttonStart.setOnClickListener {
            collectStatistic.pushDataToFirebaseOnClickButton()
            setLightMode()
        }

        binding.beamLayout.setOnClickListener {
            //In case on click layout
            collectStatistic.pushDataToFirebaseOnClickLayout()

        }
    }

    private fun setLightMode() {
        if (isLight){
            beam.flashOff()
            isLight = false
            binding.buttonStart.setImageResource(R.drawable.button_off)
        } else {
            beam.flashOn()
            isLight = true
            binding.buttonStart.setImageResource(R.drawable.button_on)
        }
    }
}