package pro.vishnevskiy

import android.content.Context
import android.provider.Settings
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.Calendar

class CollectStatistic(private val context: Context) {

    val db = FirebaseDatabase.getInstance()

    fun pushDataToFirebaseOnCreate(){
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val currentDateAndTime = dateFormat.format(calendar.time)

        val dataToPush = getDataFromSystem()
        val reference = db.getReference("OnCreate $currentDateAndTime")
        reference.setValue("OnCreate loaded $dataToPush")
    }

    fun pushDataToFirebaseOnClickButton(){
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val currentDateAndTime = dateFormat.format(calendar.time)

        val dataToPush = getDataFromSystem()
        val reference = db.getReference("OnClickButton $currentDateAndTime")
        reference.setValue("OnClickButton loaded $dataToPush")
    }

    fun pushDataToFirebaseOnClickLayout(){
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val currentDateAndTime = dateFormat.format(calendar.time)

        val dataToPush = getDataFromSystem()
        val reference = db.getReference("OnClickLayout $currentDateAndTime")
        reference.setValue("OnClickLayout loaded $dataToPush")
    }

    private fun getDataFromSystem() : String {
        val ADB_ENABLED = Settings.Global.getString(context.contentResolver, Settings.Global.ADB_ENABLED)
        val DEVICE_NAME = Settings.Global.getString(context.contentResolver, Settings.Global.DEVICE_NAME)
        val AIRPLANE_MODE_ON = Settings.Global.getString(context.contentResolver, Settings.Global.AIRPLANE_MODE_ON)
        val ALWAYS_FINISH_ACTIVITIES = Settings.Global.getString(context.contentResolver, Settings.Global.ALWAYS_FINISH_ACTIVITIES)
        val BOOT_COUNT = Settings.Global.getString(context.contentResolver, Settings.Global.BOOT_COUNT)
        val DEVELOPMENT_SETTINGS_ENABLED = Settings.Global.getString(context.contentResolver, Settings.Global.DEVELOPMENT_SETTINGS_ENABLED)
        val WIFI_ON = Settings.Global.getString(context.contentResolver, Settings.Global.WIFI_ON)
        val _ID = Settings.Global.getString(context.contentResolver, Settings.Global._ID)
        val NETWORK_PREFERENCE = Settings.Global.getString(context.contentResolver, Settings.Global.NETWORK_PREFERENCE)
        val WIFI_DEVICE_OWNER_CONFIGS_LOCKDOWN = Settings.Global.getString(context.contentResolver, Settings.Global.WIFI_DEVICE_OWNER_CONFIGS_LOCKDOWN)
        val USE_GOOGLE_MAIL = Settings.Global.getString(context.contentResolver, Settings.Global.USE_GOOGLE_MAIL)
        val VALUE = Settings.Global.getString(context.contentResolver, Settings.Global.VALUE)
        val WINDOW_ANIMATION_SCALE = Settings.Global.getString(context.contentResolver, Settings.Global.WINDOW_ANIMATION_SCALE)
        val ACTION_ACCESSIBILITY_SETTINGS = Settings.Global.getString(context.contentResolver, Settings.ACTION_ACCESSIBILITY_SETTINGS)
        val ACTION_CAST_SETTINGS = Settings.Global.getString(context.contentResolver, Settings.ACTION_CAST_SETTINGS)

        val data: String = "" +
                "ADB_ENABLED is $ADB_ENABLED " +
                "DEVICE_NAME is $DEVICE_NAME " +
                "AIRPLANE_MODE_ON is $AIRPLANE_MODE_ON" +
                "ALWAYS_FINISH_ACTIVITIES is $ALWAYS_FINISH_ACTIVITIES " +
                "BOOT_COUNT is $BOOT_COUNT " +
                "DEVELOPMENT_SETTINGS_ENABLED is $DEVELOPMENT_SETTINGS_ENABLED " +
                "WIFI_ON is $WIFI_ON " +
                "_ID is $_ID " +
                "NETWORK_PREFERENCE is $NETWORK_PREFERENCE " +
                "WIFI_DEVICE_OWNER_CONFIGS_LOCKDOWN is $WIFI_DEVICE_OWNER_CONFIGS_LOCKDOWN " +
                "USE_GOOGLE_MAIL is $USE_GOOGLE_MAIL " +
                "VALUE is $VALUE " +
                "WINDOW_ANIMATION_SCALE is $WINDOW_ANIMATION_SCALE " +
                "ACTION_ACCESSIBILITY_SETTINGS is $ACTION_ACCESSIBILITY_SETTINGS " +
                "ACTION_CAST_SETTINGS is $ACTION_CAST_SETTINGS "

        return data
    }

}