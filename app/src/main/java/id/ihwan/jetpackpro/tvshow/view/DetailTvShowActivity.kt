package id.ihwan.jetpackpro.tvshow.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import id.ihwan.jetpackpro.R
import id.ihwan.jetpackpro.tvshow.viewmodel.DetailTvShowViewModel

class DetailTvShowActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProviders.of(this).get(DetailTvShowViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv_show)

        val id = intent.getIntExtra("detail", 0)
        //initView(viewModel.detailTvShow(id))
    }


}
