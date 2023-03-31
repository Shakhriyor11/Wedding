package com.example.wedding;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wedding.adapter.ImageAdapter;
import com.example.wedding.adapter.ImageAdapter2;
import com.example.wedding.adapter.ServiceAdapter;
import com.example.wedding.adapter.VpEventsAdapter;
import com.example.wedding.adapter.VpEventsEstablishmentAdapter;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView recyclerView1;
    private RecyclerView rvServices;
    private ViewPager2 vpEvents;
    private ViewPager2 vpEstablishment;
    private VpEventsAdapter vpEventsAdapter;
    private VpEventsEstablishmentAdapter vpEventsEstablishmentAdapter;
    private ServiceAdapter serviceAdapter;
    private ImageView dwImage;
    private TextView dwTitle;
    private TextView dwDescription;
    private TextView dwPrice;
    private AppCompatButton statementButton;

    private Dialog dialog;
    private AlertDialog.Builder builder;
    private TextView statementTitle;
    private TextView statementDescription;
    private ImageView closeButton;
    private AppCompatButton registerButton;

    private EditText editTextDate;
    private ImageView imgCalendar;
    private DatePickerDialog.OnDateSetListener setListener;

    ArrayList<Image> images = new ArrayList<>();
    ArrayList<Image2> images2 = new ArrayList<>();
    ArrayList<Services> services = new ArrayList<>();
    ArrayList<VpEvents> events = new ArrayList<>();


    int[] establishmentImgs = {R.drawable.establishment, R.drawable.vp_eventsestablishment, R.drawable.establishment2};
    String[] establishmentTitle = {"Элитный ресторан", "Элитный ресторан", "Элитный ресторан"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//      galaryadagi birinchi recyclerviewni ishga tushiryabmiz
        setImages();
        recyclerView = findViewById(R.id.image_list);
        ImageAdapter imageAdapter = new ImageAdapter(this, images);
        recyclerView.setAdapter(imageAdapter);
//      galaryadagi ikkinchi recyclerviewni ishga tushiryabmiz
        setImage();
        recyclerView1 = findViewById(R.id.image_list2);
        ImageAdapter2 imageAdapter2 = new ImageAdapter2(this, images2);
        recyclerView1.setAdapter(imageAdapter2);

//      tadbirlar bo'limidagi viewpagerni ishga tushiryabmiz
        setEventsData();
        vpEvents = findViewById(R.id.viewPagerEvents);
        vpEventsAdapter = new VpEventsAdapter(events, new VpEventsAdapter.OnCheckedListener() {
            @Override
            public void onClickChecked(VpEvents events) {
                Toast.makeText(MainActivity.this, "Checked", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                ViewGroup viewGroup = findViewById(R.id.scrollview);
                View registerView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.registration_dialog_window_layout, viewGroup, false);
                builder.setView(registerView);
                AlertDialog alertDialog = builder.create();

                editTextDate = registerView.findViewById(R.id.editTextDate);
                imgCalendar = registerView.findViewById(R.id.imgCalendar);
                registerButton = registerView.findViewById(R.id.registrationButton);
                closeButton = registerView.findViewById(R.id.closeButton);

                registerButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.cancel();
                        Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                    }
                });

                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.cancel();
                    }
                });

                final Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);

//                imgCalendar.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Toast.makeText(MainActivity.this, "calendar", Toast.LENGTH_SHORT).show();
//                    }
//                });
                imgCalendar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                month = month + 1;
                                String date = day + "/" + month + "/" + year;
                                editTextDate.setText(date);
                            }
                        }, year, month, day);
                        datePickerDialog.show();
                    }
                });


                alertDialog.show();
            }
        });

        vpEvents.setClipToPadding(false);
        vpEvents.setClipChildren(false);
        vpEvents.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        vpEvents.setOffscreenPageLimit(3);
        vpEvents.setAdapter(vpEventsAdapter);
        vpEvents.setCurrentItem(1);

        CompositePageTransformer transformer = new CompositePageTransformer();
        transformer.addTransformer(new MarginPageTransformer(25));
        transformer.addTransformer((page, position) -> {
            float v = 1 - Math.abs(position);
            page.setScaleY(0.8f + v * 0.2f);
        });

        vpEvents.setPageTransformer(transformer);

//      tadbirlar o'tkaziladigan binolar bo'limidagi viewpagerni ishga tushiryabmiz
        vpEstablishment = findViewById(R.id.viewPager_EventsEstablishment);
        vpEventsEstablishmentAdapter = new VpEventsEstablishmentAdapter(establishmentImgs, establishmentTitle);

        vpEstablishment.setClipToPadding(false);
        vpEstablishment.setClipChildren(false);
        vpEstablishment.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        vpEstablishment.setOffscreenPageLimit(3);
        vpEstablishment.setAdapter(vpEventsEstablishmentAdapter);
        vpEstablishment.setCurrentItem(1);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(25));
        compositePageTransformer.addTransformer((page, position) -> {
            float v = 1 - Math.abs(position);
            page.setScaleY(0.8f + v * 0.2f);
        });

        vpEstablishment.setPageTransformer(compositePageTransformer);

//      hizmatlar bo'limidagi recyclerviewni ishga tushiryabmiz
        setServicesData();
        rvServices = findViewById(R.id.rvServices);
        serviceAdapter = new ServiceAdapter(services, new ServiceAdapter.OnItemTouchClickListener() {
            @Override
            public void onItemClick(Services services) {
                Toast.makeText(MainActivity.this, services.getServicesTitle(), Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                ViewGroup viewGroup = findViewById(R.id.scrollview);
                View dialogView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_dialog_layout, viewGroup, false);
                dwImage = dialogView.findViewById(R.id.ivDialog);
                dwImage.setImageResource(services.getServicesImg());
                dwTitle = dialogView.findViewById(R.id.dialog_title);
                dwTitle.setText(services.getServicesTitle());
                dwDescription = dialogView.findViewById(R.id.dialog_description);
                dwDescription.setText(services.getServicesDescription());
                dwPrice = dialogView.findViewById(R.id.dialog_price);
                dwPrice.setText(services.getServicesPrice());
                builder.setView(dialogView);
                AlertDialog alertDialog = builder.create();
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog.show();
            }

            @Override
            public void onButtonClick(Services services) {
                Toast.makeText(MainActivity.this, "Button bosildi", Toast.LENGTH_SHORT).show();
            }

        });
        rvServices.setAdapter(serviceAdapter);

        dialog = new Dialog(MainActivity.this);

        statementButton = findViewById(R.id.checkOut_button);

    }

    public void showStatementDialogWindow(View view) {
        String title = "Ваша заявка принята";
        String description = "Мы вам позвоним, спасибо что пользуетесь нашими услугами.";
        builder = new AlertDialog.Builder(MainActivity.this);
        statementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewGroup viewGroup = findViewById(R.id.scrollview);
                View statementView = LayoutInflater.from(view.getContext()).inflate(R.layout.statement_dialog_window_layout, viewGroup, false);
                statementTitle = statementView.findViewById(R.id.statement_title);
                statementTitle.setText(title);
                statementDescription = statementView.findViewById(R.id.statement_description);
                statementDescription.setText(description);
//                builder.setTitle(title);
//                builder.setMessage(description);

                builder.setView(statementView);
                AlertDialog alertDialog = builder.create();
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog.show();
            }
        });
    }

    private void showServicesInfo() {
        dialog.setContentView(R.layout.custom_dialog_layout);
        dialog.getWindow();
        dialog.setCancelable(true);
    }

    public void setImages() {
        images.add(new Image(R.drawable.main_img, R.drawable.img1, R.drawable.img1));
        images.add(new Image(R.drawable.img1, R.drawable.img1, R.drawable.img1));
        images.add(new Image(R.drawable.img2, R.drawable.img1, R.drawable.img1));
    }

    public void setImage() {
        images2.add(new Image2(R.drawable.second_image));
        images2.add(new Image2(R.drawable.second_image));
        images2.add(new Image2(R.drawable.second_image));
    }

    public void setServicesData() {
        services.add(new Services(R.drawable.keytering, "Кейтеринг", "Персонал обеспечит сервис высокого класса, эффектную подачу блюд, элегантное оформление столов.", "Price:  100 $"));
        services.add(new Services(R.drawable.oformleniya, "Оформление", "Качественная оформление свадеб, день рождений, детских праздников и др.", "Price:  100 $"));
        services.add(new Services(R.drawable.syomki, "Фото и видеосъемка", "Персонал обеспечит сервис высокого класса, эффектную подачу блюд, элегантное оформление столов.", "Price:  100 $"));
        services.add(new Services(R.drawable.oformileniya, "Оформление", "Качественная оформление свадеб, день рождений, детских праздников и др.", "Price:  100 $"));
    }

    public void setEventsData() {
        events.add(new VpEvents(R.drawable.img2, "Вечеринки"));
        events.add(new VpEvents(R.drawable.vp_image1, "Свадьба"));
        events.add(new VpEvents(R.drawable.second_image, "Вечеринки"));
    }

}