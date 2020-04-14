package jp.co.stv_tech.android_7_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("LifeCycleSample", "Main onCreate() called.")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvMenu = findViewById<ListView>(R.id.lvMenu)

        val menuList: MutableList<MutableMap<String, String>> = mutableListOf()

        var menu = mutableMapOf("name" to "唐揚げ定食", "price" to "800円")
        menuList.add(menu)

        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to "850円")
        menuList.add(menu)

        val from = arrayOf("name", "price")

        val to = intArrayOf(android.R.id.text1, android.R.id.text2)

        val adapter = SimpleAdapter(applicationContext, menuList, android.R.layout.simple_list_item_2, from, to)
        lvMenu.adapter = adapter

        lvMenu.onItemClickListener = ListItemClickListener()

    }

    public override fun onStart() {
        Log.i("LifeCycleSample", "Main onStart() called.")
        super.onStart()
    }

    public override fun onRestart() {
        Log.i("LifeCycleSample", "Main onRestart() called.")
        super.onRestart()
    }

    public override fun onResume() {
        Log.i("LifeCycleSample", "Main onResume() called.")
        super.onResume()
    }

    public override fun onPause() {
        Log.i("LifeCycleSample", "Main onPause() called.")
        super.onPause()
    }

    public override fun onStop() {
        Log.i("LifeCycleSample", "Main onStop() called.")
        super.onStop()
    }

    public override fun onDestroy() {
        Log.i("LifeCycleSample", "Main onDestory() called.")
        super.onDestroy()
    }



    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {

            val item = parent.getItemAtPosition(position) as MutableMap<String, String>

            val menuName = item["name"]
            val menuPrice = item["price"]

            val intent = Intent(applicationContext, MenuThanksActivity::class.java)

            intent.putExtra("menuName", menuName)
            intent.putExtra("menuPrice", menuPrice)

            startActivity(intent)
        }
    }
}
