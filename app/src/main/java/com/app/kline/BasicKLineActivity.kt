package com.app.kline

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import com.app.kline.utils.DataUtils
import com.liihuu.kline.R
import kotlinx.android.synthetic.main.kline_layout.k_line_chart

/**
 * @Author lihu hu_li888@foxmail.com
 * @Date 2019-09-23-23:23
 */
open class BasicKLineActivity : BasicActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataList = DataUtils.generatedKLineDataList(generatedKLineDataCount())
        val bitmap: Bitmap? = BitmapFactory.decodeResource(resources, R.drawable.setting)
        k_line_chart.candle.logoBitmap = bitmap
        k_line_chart.addData(dataList)


    }

    override fun generatedLayoutId(): Int = R.layout.activity_basic_kline

    /**
     * 获取需要生成k线数据的个数
     * @return Int
     */
    open fun generatedKLineDataCount(): Int = 2000
}