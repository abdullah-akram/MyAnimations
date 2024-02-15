package ai.issm.myanimations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.carousel.CarouselLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MotionAnimation extends AppCompatActivity  {


   private final ArrayList<ItemData> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_animation);

        RecyclerView recyclerView = findViewById(R.id.carousel_recycler_view);
        list.add(new ItemData("https://www.gstatic.com/webp/gallery/1.jpg") );
        list.add(new ItemData("https://www.gstatic.com/webp/gallery/2.jpg") );
        list.add(new ItemData("https://www.gstatic.com/webp/gallery/3.jpg") );
        list.add(new ItemData("https://www.gstatic.com/webp/gallery/4.jpg") );
        list.add(new ItemData("https://www.gstatic.com/webp/gallery/5.jpg") );

        recyclerView.setAdapter(new RV_Adapter(list, MotionAnimation.this));
        recyclerView.setLayoutManager(new CarouselLayoutManager());


//        recyclerView.setLayoutManager(new CarouselLayoutManager());



    }
}