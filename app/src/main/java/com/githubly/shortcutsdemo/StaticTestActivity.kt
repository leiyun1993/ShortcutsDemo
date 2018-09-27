package com.githubly.shortcutsdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 类名：StaticTestActivity
 * 作者：Yun.Lei
 * 功能：
 * 创建日期：2018-09-27 10:23
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
class StaticTestActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pageInfo.text = "static shortcuts target class"
    }
}