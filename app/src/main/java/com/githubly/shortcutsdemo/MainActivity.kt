package com.githubly.shortcutsdemo

import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

/**
 * shortcuts
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pageInfo.text = "main activity"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            val shortcutManager = getSystemService(ShortcutManager::class.java)

            val count = shortcutManager.maxShortcutCountPerActivity
            Log.e("count",count.toString())

            val list = mutableListOf<ShortcutInfo>()
            addShortcutWithIntent1()?.let {
                list.add(it)
            }
            /*addShortcutWithIntent2()?.let {
                list.add(it)
            }*/
            addShortcutWithIntents()?.let {
                list.add(it)
            }
            shortcutManager.dynamicShortcuts =list
        }


    }

    private fun addShortcutWithIntent1(): ShortcutInfo? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            ShortcutInfo.Builder(this, "Dynamic1").apply {
                setShortLabel("动态快捷1")
                setLongLabel("DynamicShortcutLong1")
                setIcon(Icon.createWithResource(this@MainActivity, R.mipmap.icon3))
                setIntent(Intent().apply {
                    action = Intent.ACTION_MAIN
                    setClass(this@MainActivity, DynamicTestActivity::class.java)
                    putExtra("info", "Dynamic shortcuts target class with intent1")
                })
            }.build()
        } else {
            null
        }
    }

    private fun addShortcutWithIntent2(): ShortcutInfo? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            ShortcutInfo.Builder(this, "Dynamic2").apply {
                setShortLabel("动态快捷2")
                setLongLabel("DynamicShortcutLong2")
                setIcon(Icon.createWithResource(this@MainActivity, R.mipmap.icon4))
                setIntent(Intent().apply {
                    action = Intent.ACTION_MAIN
                    setClass(this@MainActivity, DynamicTestActivity::class.java)
                    putExtra("info", "Dynamic shortcuts target class with intent2")
                })
            }.build()
        } else {
            null
        }
    }

    private fun addShortcutWithIntents(): ShortcutInfo? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            ShortcutInfo.Builder(this, "Dynamic3").apply {
                setShortLabel("动态快捷3")
                setLongLabel("DynamicShortcutLong3")
                setIcon(Icon.createWithResource(this@MainActivity, R.mipmap.icon5))
                setIntents(arrayOf(
                        Intent().apply {
                            action = Intent.ACTION_MAIN
                            setClass(this@MainActivity, MainActivity::class.java)
                            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                        },
                        Intent().apply {
                            action = Intent.ACTION_MAIN
                            setClass(this@MainActivity, DynamicTestActivity::class.java)
                            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                            putExtra("info", "Dynamic shortcuts target class with intents")
                        }
                )
                )
            }.build()
        } else {
            null
        }
    }
}
