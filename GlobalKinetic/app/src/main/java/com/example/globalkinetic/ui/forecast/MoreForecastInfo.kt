package com.example.globalkinetic.ui.forecast

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.afollestad.materialdialogs.MaterialDialog
import com.example.globalkinetic.MainActivity
import com.example.globalkinetic.R
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class MoreForecastInfo : AppCompatActivity() {

     companion object{
         private val TAG = "MoreForecastInfo"
     }

    private lateinit var foreCastViewModel: MoreForecastInfoViewModel
    private lateinit var txtTemperature: TextView
    private lateinit var txtTempMin: TextView
    private lateinit var txtTempMax: TextView
    private lateinit var txtMainDescr: TextView
    private lateinit var txtFullDescr: TextView
    private lateinit var imgIcon: ImageView
    private lateinit var txtDate: TextView
    private lateinit var txtPressure: TextView
    private lateinit var txtFells: TextView
    private lateinit var txtCityName: TextView
    private lateinit var txtBigTemp: TextView
    private lateinit var txtCountryName: TextView
    private lateinit var moreDetailsView: ScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_forecast_info)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        title = "More Details"

        init()

        //here initializing my view model
        foreCastViewModel = ViewModelProvider(
            this,ViewModelProvider.AndroidViewModelFactory.getInstance(application))
            .get(MoreForecastInfoViewModel::class.java)


    }

    @SuppressLint("SetTextI18n")
    fun init(){

        txtTemperature = findViewById(R.id.txtTemp_value)
        txtTempMin = findViewById(R.id.txtTempMin)
        txtTempMax = findViewById(R.id.txtTempMax)
        txtMainDescr = findViewById(R.id.txtMain)
        txtFullDescr = findViewById(R.id.txtDescription)
        imgIcon = findViewById(R.id.imgIcon)
        txtDate = findViewById(R.id.txtDate)
        txtPressure = findViewById(R.id.txtPressure)
        txtFells = findViewById(R.id.txtFells)
        txtCityName = findViewById(R.id.txtCityName)
        txtCountryName = findViewById(R.id.txtCountryName)
        txtBigTemp = findViewById(R.id.txtBigTemp)
        moreDetailsView = findViewById(R.id.main_more_info_layout)

        //now set values to show on my design
        txtTemperature.text = intent.getStringExtra("TEMPERATURE").toString() + "\u2103"
        txtTempMin.text = intent.getStringExtra("TEMPMIN").toString()+ "\u2103"
        txtTempMax.text = intent.getStringExtra("TEMPMAX").toString()+ "\u2103"
        txtMainDescr.text = intent.getStringExtra("MAINDESCR").toString()
        txtFullDescr.text = intent.getStringExtra("FULLDESCR").toString()
        txtPressure.text = intent.getStringExtra("PRESSURE").toString()+ "\u2103"
        txtFells.text = intent.getStringExtra("FEELS").toString()+ "\u2103"
        txtDate.text = intent.getStringExtra("DATE").toString()
        txtCityName.text = intent.getStringExtra("CITYNAME").toString()

        txtBigTemp.text = intent.getStringExtra("TEMPERATURE").toString() + "\u2103"

        //here get the full country name from the code
        //var locale = Locale("",intent.getStringExtra("COUNTRYNAME").toString())

        txtCountryName.text = getCountryOnCode(intent.getStringExtra("COUNTRYNAME").toString())



        //HERE I WANT TO SEE IF I HAVE RECEIVED MY VALUES FROM PREVOIUS ADAPTER
        val cityName:String = intent.getStringExtra("CITYNAME").toString()
        val countryName:String = intent.getStringExtra("COUNTRYNAME").toString()

        Log.d(TAG,"CITYOBJECT: cityName: $cityName : country: $countryName ")

        //will use the returned text to set weather icon:
        var iconText: String? = intent.getStringExtra("MAINDESCR").toString()


        if(iconText.equals("Clear")){
            imgIcon.setImageResource(R.drawable.clear)
            moreDetailsView.setBackgroundColor(Color.parseColor("#4c94e3"))

        }else if(iconText.equals("Rain")){
            imgIcon.setImageResource(R.drawable.rain)
            moreDetailsView.setBackgroundColor(Color.parseColor("#57575D"))

        }else if (iconText.equals("Sunny")){
            imgIcon.setImageResource(R.drawable.partlysunny)
            moreDetailsView.setBackgroundColor(Color.parseColor("#4c94e3"))

        }else if (iconText.equals("Clouds")){
            imgIcon.setImageResource(R.drawable.partlysunny)
            moreDetailsView.setBackgroundColor(Color.parseColor("#54717A"))
        }

        Log.d(TAG,"ICON_TEXT: $iconText")

    }

    fun getCountryOnCode(countryCode:String):String{
        var locale = Locale("",countryCode)
        return locale.getDisplayCountry()
    }

    //using this function to convert the temperature to one decimal value
    fun convertToOneDegit(digtValue: Double?):String{


        var locale:Locale = Locale("en","UK")
        var pattern:String = "#"

        var decimalFormat:DecimalFormat = NumberFormat.getNumberInstance(locale) as DecimalFormat
        decimalFormat.applyPattern(pattern)

        return decimalFormat.format(digtValue)

    }


    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){onBackPressed()}
        return super.onOptionsItemSelected(item)
    }

}