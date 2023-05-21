package pro.vishnevskiy

import android.content.Context
import android.hardware.camera2.CameraManager
import android.util.Log
import android.widget.Toast
import java.lang.Exception

class Beam (private val context: Context) {

    private val cameraManager: CameraManager =
        context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
    private val cameraId = cameraManager.cameraIdList[0]


    fun flashOn(){
        try {
            cameraManager.setTorchMode(cameraId, true)
        }catch (ex: Exception){
            Log.d("123123", "The exception is $ex")
        }
    }

    fun flashOff(){
        try {
            cameraManager.setTorchMode(cameraId, false)
        }catch (ex: Exception){
            Log.d("123123", "The exception is $ex")
        }
    }
}