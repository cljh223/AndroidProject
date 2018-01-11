package com.github.florent37.materialviewpager.sample;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class SecondTestRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Object> contents;

    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;

    static String shopWhere = new FirstTestRecyclerViewAdapter().shopWhere;

    TextView textView;
    String jsontext;
    ProgressDialog progressDialog;
    ImageView radioImg2;
    ImageView ramenImg2;
    TextView ramenName;
    TextView district;
    TextView usage;
    TextView amount;

    View view2 = null;

    TableRow tb1;
    TableRow tb2;
    TableRow tb3;
    TableRow tb4;
    TableRow tb5;
    TableRow tb6;
    TableRow tb7;
    TableRow tb8;
    TableRow tb9;
    TableRow tb10;

    TextView code1;
    TextView code2;
    TextView code3;
    TextView code4;
    TextView code5;
    TextView code6;
    TextView code7;
    TextView code8;
    TextView code9;
    TextView code10;

    String text1;
    String text2;
    String text3;
    String text4;
    String text5;
    String text6;
    String text7;
    String text8;
    String text9;
    String text10;

    String etString;

    ArrayList<String> searchlist = new ArrayList<>();
    ArrayList<TableRow> tblist = new ArrayList<>();
    Button selectbtn;

    public SecondTestRecyclerViewAdapter(List<Object> contents) {
        this.contents = contents;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_HEADER;
            default:
                return TYPE_CELL;
        }
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = null;
        switch (MainActivity.WHERE) {
            case "purchase":
                switch (viewType) {
                    case TYPE_HEADER: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_small_purchase, parent, false);
                        view.findViewById(R.id.purchaseFirstSmallLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.purchaseSecondSmallLayout).setVisibility(View.VISIBLE);
                        view.findViewById(R.id.purchaseThirdSmallLayout).setVisibility(View.GONE);
                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                    case TYPE_CELL: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_big_purchase, parent, false);
                        view.findViewById(R.id.purchaseFirstBigLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.purchaseSecondBigLayout).setVisibility(View.VISIBLE);
                        view.findViewById(R.id.purchaseThirdBigLayout).setVisibility(View.GONE);

                        selectclicked(view);
                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                }
            case "production":
                switch (viewType) {
                    case TYPE_HEADER: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_small_production, parent, false);
                        view.findViewById(R.id.productionFirstSmallLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.productionSecondSmallLayout).setVisibility(View.VISIBLE);
                        view.findViewById(R.id.productionThirdSmallLayout).setVisibility(View.GONE);
                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                    case TYPE_CELL: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_big_production, parent, false);
                        view.findViewById(R.id.productionFirstBigLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.productionSecondBigLayout).setVisibility(View.VISIBLE);
                        view.findViewById(R.id.productionThirdBigLayout).setVisibility(View.GONE);
                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                }
            case "logistics":
                switch (viewType) {
                    case TYPE_HEADER: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_small_logistics, parent, false);
                        view.findViewById(R.id.logisticsFirstSmallLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.logisticsSecondSmallLayout).setVisibility(View.VISIBLE);
                        view.findViewById(R.id.logisticsThirdSmallLayout).setVisibility(View.GONE);

                        /*뷰 이벤트 추가*/
                        progressBarChange(view);
                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                    case TYPE_CELL: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_big_logistics, parent, false);
                        view.findViewById(R.id.logisticsFirstBigLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.logisticsSecondBigLayout).setVisibility(View.VISIBLE);
                        view.findViewById(R.id.logisticsThirdBigLayout).setVisibility(View.GONE);

                        /*라디오버튼 이벤트 추가*/
                        onRadioButtonClicked(view);
                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                }
            case "sales":
                switch (viewType) {
                    case TYPE_HEADER: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_small_sales, parent, false);
                        view.findViewById(R.id.salesFirstSmallLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.salesSecondSmallLayout).setVisibility(View.VISIBLE);
                        view.findViewById(R.id.salesThirdSmallLayout).setVisibility(View.GONE);
                        view2 = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_big_sales, parent, false);

                        Spinner s = (Spinner) view.findViewById(R.id.salesSpinner);
                        final TextView textView = (TextView) view.findViewById(R.id.salesFirstSmallLayoutTitle);
                        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view,
                                                       int position, long id) {
                                ((TextView) view).setTextColor(Color.BLACK);
                                switch (String.valueOf(parent.getItemAtPosition(position))) {
                                    case "롯데마트 삼성점":
                                        shopWhere = "롯데마트 삼성점";
                                        view2.findViewById(R.id.firstShopLayout).setVisibility(View.VISIBLE);
                                        view2.findViewById(R.id.secondShopLayout).setVisibility(View.GONE);

                                        break;
                                    case "GS수퍼마켓 강남대치점":
                                        shopWhere = "GS수퍼마켓 강남대치점";
                                        view2.findViewById(R.id.firstShopLayout).setVisibility(View.GONE);
                                        view2.findViewById(R.id.secondShopLayout).setVisibility(View.VISIBLE);
                                        break;
                                }
                                /*textView.setText(shopWhere);*/
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });


                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                    case TYPE_CELL: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_big_sales, parent, false);
                        view.findViewById(R.id.salesFirstBigLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.salesSecondBigLayout).setVisibility(View.VISIBLE);
                        view.findViewById(R.id.salesThirdBigLayout).setVisibility(View.GONE);
                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                }

                return new RecyclerView.ViewHolder(view) {
                };
        }
        return null;
    }


    public void selectclicked(View view){



        tb1 = view.findViewById(R.id.plist01);
        tb2 = view.findViewById(R.id.plist02);
        tb3 = view.findViewById(R.id.plist03);
        tb4 = view.findViewById(R.id.plist04);
        tb5 = view.findViewById(R.id.plist05);
        tb6 = view.findViewById(R.id.plist06);
        tb7 = view.findViewById(R.id.plist07);
        tb8 = view.findViewById(R.id.plist08);
        tb9 = view.findViewById(R.id.plist09);
        tb10 = view.findViewById(R.id.plist10);

        tblist.add(tb1);
        tblist.add(tb2);
        tblist.add(tb3);
        tblist.add(tb4);
        tblist.add(tb5);
        tblist.add(tb6);
        tblist.add(tb7);
        tblist.add(tb8);
        tblist.add(tb9);
        tblist.add(tb10);




        code1 = view.findViewById(R.id.code1);
        code2 = view.findViewById(R.id.code2);
        code3 = view.findViewById(R.id.code3);
        code4 = view.findViewById(R.id.code4);
        code5 = view.findViewById(R.id.code5);
        code6 = view.findViewById(R.id.code6);
        code7 = view.findViewById(R.id.code7);
        code8 = view.findViewById(R.id.code8);
        code9 = view.findViewById(R.id.code9);
        code10 = view.findViewById(R.id.code10);

        text1 = code1.getText().toString();
        text2 = code2.getText().toString();
        text3 = code3.getText().toString();
        text4 = code4.getText().toString();
        text5 = code5.getText().toString();
        text6 = code6.getText().toString();
        text7 = code7.getText().toString();
        text8 = code8.getText().toString();
        text9 = code9.getText().toString();
        text10 = code10.getText().toString();

        searchlist.add(text1);
        searchlist.add(text2);
        searchlist.add(text3);
        searchlist.add(text4);
        searchlist.add(text5);
        searchlist.add(text6);
        searchlist.add(text7);
        searchlist.add(text8);
        searchlist.add(text9);
        searchlist.add(text10);


        Log.i("====>", searchlist.toString());
        final EditText et = view.findViewById(R.id.search_process);
        selectbtn = view.findViewById(R.id.search_btn);
        selectbtn.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view2) {


                etString = et.getText().toString();
                Log.i("etString",etString);

                for(int i = 0; i <10 ; i++){
                    Log.v("=====>EditValue", etString);
                    Log.v("=====>"+i+"",searchlist.get(i) );
                    if(etString.equals(searchlist.get(i))){
                        Log.v("====>3", searchlist.toString());
                        tblist.get(i).setVisibility(View.VISIBLE);
                    }
                    else{
                        tblist.get(i).setVisibility(View.GONE);
                    }

                }
            }
        });

    }



    public void onRadioButtonClicked(View view){
        radioImg2 = view.findViewById(R.id.radioImg2);
        ramenImg2 = view.findViewById(R.id.ramenImg2);
        ramenName = view.findViewById(R.id.ramenName2);
        district = view.findViewById(R.id.district2);
        usage = view.findViewById(R.id.usage2);
        amount = view.findViewById(R.id.amount2);

        /*라디오버튼2_1*/
        RadioButton btn21 = view.findViewById(R.id.logi_button21);
        btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg2.setImageResource(R.drawable.logi_21);
                ramenImg2.setImageResource(R.drawable.ansung_ramen);
                ramenName.setText("안성탕면");
                district.setText("A구역 / 45㎢");
                usage.setText("68%");
                amount.setText("420개");
            }
        });

        //*라디오버튼2_2*/
        RadioButton btn22 = view.findViewById(R.id.logi_button22);
        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg2.setImageResource(R.drawable.logi_22);
                ramenImg2.setImageResource(R.drawable.sin_ramen);
                ramenName.setText("신라면");
                district.setText("B구역 / 45㎢");
                usage.setText("57%");
                amount.setText("347개");
            }
        });

        /*라디오버튼2_3*/
        RadioButton btn23 = view.findViewById(R.id.logi_button23);
        btn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg2.setImageResource(R.drawable.logi_23);
                ramenImg2.setImageResource(R.drawable.nugool_ramen);
                ramenName.setText("너구리");
                district.setText("C구역 / 30㎢");
                usage.setText("75%");
                amount.setText("561개");
            }
        });

        /*라디오버튼2_4*/
        RadioButton btn24 = view.findViewById(R.id.logi_button24);
        btn24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg2.setImageResource(R.drawable.logi_24);
                ramenImg2.setImageResource(R.drawable.anchovy_ramen);
                ramenName.setText("멸치칼국수");
                district.setText("D구역 / 30㎢");
                usage.setText("90%");
                amount.setText("598개");
            }
        });

        /*라디오버튼2_5*/
        RadioButton btn25 = view.findViewById(R.id.logi_button25);
        btn25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg2.setImageResource(R.drawable.logi_25);
                ramenImg2.setImageResource(R.drawable.sari_ramen);
                ramenName.setText("사리곰탕");
                district.setText("E구역 / 30㎢");
                usage.setText("83%");
                amount.setText("603개");
            }
        });
    }

    public void progressBarChange(View view){
        /*ProgressBar 수치 변경*/
        ProgressBar progressBar21 = (ProgressBar)view.findViewById(R.id.progressBar2_1);
        progressBar21.setProgress(68);
        ProgressBar progressBar22 = (ProgressBar)view.findViewById(R.id.progressBar2_2);
        progressBar22.setProgress(57);
        ProgressBar progressBar23 = (ProgressBar)view.findViewById(R.id.progressBar2_3);
        progressBar23.setProgress(75);
        ProgressBar progressBar24 = (ProgressBar)view.findViewById(R.id.progressBar2_4);
        progressBar24.setProgress(90);
        ProgressBar progressBar25 = (ProgressBar)view.findViewById(R.id.progressBar2_5);
        progressBar25.setProgress(83);

        /*ProgressBar 텍스트 변경*/
        TextView textView21 = (TextView)view.findViewById(R.id.index2_1);
        textView21.setText("68%");
        TextView textView22 = (TextView)view.findViewById(R.id.index2_2);
        textView22.setText("57%");
        TextView textView23 = (TextView)view.findViewById(R.id.index2_3);
        textView23.setText("75%");
        TextView textView24 = (TextView)view.findViewById(R.id.index2_4);
        textView24.setText("90%");
        TextView textView25 = (TextView)view.findViewById(R.id.index2_5);
        textView25.setText("83%");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                break;
            case TYPE_CELL:
                break;
        }
    }




}

