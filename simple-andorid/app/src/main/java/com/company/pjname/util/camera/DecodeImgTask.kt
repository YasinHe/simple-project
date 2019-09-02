package com.company.pjname.util.camera

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.widget.ImageView
import java.lang.ref.WeakReference

/**
 * Created by HeYingXin on 2019/7/22.
 */
class DecodeImgTask(imageView: ImageView) : AsyncTask<String, Int, Bitmap?>() {
    private val imageViewReference: WeakReference<ImageView> = WeakReference(imageView)
    private var temp = 0L

    override fun doInBackground(vararg params: String?): Bitmap? {
        temp = System.currentTimeMillis()
        return BitmapFactory.decodeFile(params[0])
    }

    override fun onPostExecute(bitmap: Bitmap?) {
        if (imageViewReference != null && bitmap != null) {
            imageViewReference.get()?.let {
                var compressBitmap = BitmapUtils.decodeBitmap(bitmap, 720, 1080)
                it.setImageBitmap(compressBitmap)
                Log.d("tag", "原始图片大小  ${bitmap.width} * ${bitmap.height}")
                Log.d("tag", "压缩后图片大小  ${compressBitmap.width} * ${compressBitmap.height}")
                Log.d("tag", "加载图片耗时 ${System.currentTimeMillis() - temp}")
            }
        }
        super.onPostExecute(bitmap)
    }
}