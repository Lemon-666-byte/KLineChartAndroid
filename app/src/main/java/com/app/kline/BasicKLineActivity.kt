package com.app.kline

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import com.app.kline.utils.DataUtils
import com.app.kline.R
import kotlinx.android.synthetic.main.kline_layout.k_line_chart

/**
 * @Date 2019-09-23-23:23
 */
open class BasicKLineActivity : BasicActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataList = DataUtils.generatedKLineDataList(generatedKLineDataCount())
        val bitmap: Bitmap? = BitmapFactory.decodeResource(resources, R.drawable.setting)
        k_line_chart.candle.logoBitmap = bitmap
        k_line_chart.addData(dataList)

        dataList.lastOrNull()?.let {
            k_line_chart.postDelayed(
                { k_line_chart.setZoomScale((it.closePrice / 10).toFloat()) }, 1000
            )
        }

    }

    override fun generatedLayoutId(): Int = R.layout.activity_basic_kline

    /**
     * 获取需要生成k线数据的个数
     * @return Int
     */
    open fun generatedKLineDataCount(): Int = 2000
}