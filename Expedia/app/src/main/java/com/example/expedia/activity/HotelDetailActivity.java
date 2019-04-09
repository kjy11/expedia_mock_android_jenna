package com.example.expedia.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.expedia.R;
import com.google.android.gms.maps.MapView;

import org.w3c.dom.Text;

public class HotelDetailActivity extends AppCompatActivity {
    private NestedScrollView scrollView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_detail);
        Intent intent = getIntent();
        String hotelName = intent.getStringExtra("name");
        //------------------------ 상단 바 ---------------------------------
        ImageView backImage = findViewById(R.id.cancel_btn);
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ImageView ivShare = findViewById(R.id.share_imageView);
        ivShare.setColorFilter(R.color.expedia_light_blue, PorterDuff.Mode.SRC_IN);
        TextView tvHotelName = findViewById(R.id.hotelName_textView);
        tvHotelName.setText(hotelName);
        RatingBar rbHotelRating = findViewById(R.id.ratingBar);

        //------------------------- 스크롤 뷰 ---------------------------------
        scrollView = findViewById(R.id.scrollView);
        ViewPager vpHotelImage = findViewById(R.id.hotelImage_viewPager);


        TextView tvSale = findViewById(R.id.sale_textView);
        String string = "-75%";
        tvSale.setText(string);
        TextView tvOriginalPrice = findViewById(R.id.originalPrice_textView);
        string = "￦272,727";
        tvOriginalPrice.setText(string);
        tvOriginalPrice.setPaintFlags(tvOriginalPrice.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        LinearLayout llEditPeriod = findViewById(R.id.editPeriod_layout);
        llEditPeriod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HotelDetailActivity.this, "기간 수정 기능", Toast.LENGTH_LONG).show();
            }
        });
        TextView tvPeriod = findViewById(R.id.period_textView);
        string = "5월 14일 ~ 5월 15일";
        tvPeriod.setText(string);
        TextView tvSpecialPrice = findViewById(R.id.specialPrice_textView);
        string = "￦68,182";
        tvSpecialPrice.setText(string);
        TextView tvPerson = findViewById(R.id.person_textView);
        string = "2명";
        tvPerson.setText(string);
        TextView tvPoint = findViewById(R.id.point_textView);
        string = "276포인트 적립";
        tvPoint.setText(string);
        TextView tvRatingTotal = findViewById(R.id.ratingTotal_textView);
        string = "4.2";
        tvRatingTotal.setText(string);
        TextView tvGeneralLiview = findViewById(R.id.generalReview_textView);
        string = "- 매우 좋음!";
        tvGeneralLiview.setText(string);
        TextView tvReview = findViewById(R.id.review_textView);
        string = "473개 이용 후기 보기";
        tvReview.setText(string);
        tvReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HotelDetailActivity.this, "후기로 연결", Toast.LENGTH_LONG).show();
            }
        });
        RatingBar rbClean = findViewById(R.id.clean_ratingBar);
        float rate = (float)4.2;
        rbClean.setRating(rate);
        TextView tvCleanRating = findViewById(R.id.clean_rating_textView);
        string = Float.toString(rate);
        tvCleanRating.setText(string);
        RatingBar rbComfort = findViewById(R.id.comfort_ratingBar);
        rate = (float)4.3;
        rbComfort.setRating(rate);
        TextView tvComfortRate = findViewById(R.id.comfort_rating_textView);
        string = Float.toString(rate);
        tvComfortRate.setText(string);
        RatingBar rbService = findViewById(R.id.service_ratingBar);
        rate = (float)4.1;
        rbService.setRating(rate);
        TextView tvServiceRating = findViewById(R.id.service_rating_textView);
        string = Float.toString(rate);
        tvServiceRating.setText(string);
        RatingBar rvHotelStatus = findViewById(R.id.hotelStatus_ratingBar);
        rate = (float)4.2;
        rvHotelStatus.setRating(rate);
        TextView tvHotelStatusRating = findViewById(R.id.hotelStatus_rating_textView);
        string = Float.toString(rate);
        tvHotelStatusRating.setText(string);

        LinearLayout llPayLaterInfo = findViewById(R.id.payLaterInfo_layout);
        llPayLaterInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HotelDetailActivity.this, "안내사항 액티비티",Toast.LENGTH_LONG).show();
            }
        });

        RecyclerView rvOption = findViewById(R.id.option_recyclerView);

        MapView mapView = findViewById(R.id.mapView);

        final LinearLayout llPayNowActive = findViewById(R.id.payNowActive_layout);
        final LinearLayout llPayLaterActive = findViewById(R.id.payLaterActive_layout);
        TextView llPayNow = findViewById(R.id.payNow_textView);
        TextView llPayLater = findViewById(R.id.payLater_textView);

        llPayNowActive.setVisibility(View.VISIBLE);
        llPayLaterActive.setVisibility(View.GONE);
        llPayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llPayNowActive.setVisibility(View.VISIBLE);
                llPayLaterActive.setVisibility(View.GONE);
            }
        });
        llPayLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llPayNowActive.setVisibility(View.GONE);
                llPayLaterActive.setVisibility(View.VISIBLE);
            }
        });
        RecyclerView rvRoomList = findViewById(R.id.roomList_recyclerView);

        Toast.makeText(HotelDetailActivity.this, hotelName, Toast.LENGTH_LONG).show();
    }
}