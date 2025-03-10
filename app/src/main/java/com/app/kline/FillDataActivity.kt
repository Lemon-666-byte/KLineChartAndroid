package com.app.kline

import android.os.Bundle
import android.os.Handler
import com.app.kline.utils.DataUtils
import com.app.klinechart.model.KLineModel
import com.app.kline.R
import kotlinx.android.synthetic.main.activity_fill_data.*
import kotlinx.android.synthetic.main.kline_layout.*

/**
 * @Date 2019-09-24-22:47
 */
class FillDataActivity : BasicKLineActivity() {
    private lateinit var fillDataList: MutableList<KLineModel>
    private var fillDataPos = 0

    companion object {
        const val MESSAGE_FILL_DATA = 0x002
        const val FILL_DATA_DELAY_TIME = 500L
    }

    private val h = Handler {
        when (it.what) {
            MESSAGE_FILL_DATA -> {
                k_line_chart.addData(fillDataList[fillDataPos])
                fillDataPos++
                sendDelayMessage()
            }
        }
        return@Handler true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataList = k_line_chart.getDataList()
        fillDataList = DataUtils.generatedKLineDataList(2000, dataList[dataList.size - 1].closePrice)
        btn_fill_data.setOnClickListener {
            h.removeMessages(MESSAGE_FILL_DATA)
            sendDelayMessage()
        }
    }

    override fun generatedLayoutId(): Int = R.layout.activity_fill_data

    override fun generatedKLineDataCount(): Int = 200

    private fun sendDelayMessage() {
        if (fillDataPos < fillDataList.size) {
            h.sendEmptyMessageDelayed(MESSAGE_FILL_DATA, FILL_DATA_DELAY_TIME)
        }
    }

    override fun onDestroy() {
        h.removeMessages(MESSAGE_FILL_DATA)
        super.onDestroy()
    }

}