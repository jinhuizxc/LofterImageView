package chengang.lofterimageview;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;

import chengang.library.widget.LofterGallery;

public class GalleryActivity extends AppCompatActivity implements LofterGallery.OnImageClickListener{

    private LofterGallery mLofterGallery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        mLofterGallery = (LofterGallery) findViewById(R.id.lofter_Gallery);
        mLofterGallery.setOnImageClickListener(this);
        ArrayList<String> gallery_image = getIntent().getStringArrayListExtra("GALLERY_IMAGE");
        ViewCompat.setTransitionName(mLofterGallery, "GALLERY_IMAGE");
        mLofterGallery.showGallery(gallery_image, 0);
    }

    @Override
    public void onBackPressed() {
        mLofterGallery.getLofterViewPager().setCurrentItem(0, true);
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                GalleryActivity.super.onBackPressed();
            }
        },200);
    }

    @Override
    public void onImageClick(PhotoView image) {
        onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLofterGallery.destroy();
    }
}
