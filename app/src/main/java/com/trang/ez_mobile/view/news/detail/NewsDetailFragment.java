package com.trang.ez_mobile.view.news.detail;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.trang.ez_mobile.App;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.util.custormView.TextViewFont;
import com.trang.ez_mobile.view.news.detail.tin_tuc_lien_quan.NewDetailAdapter;
import com.trang.ez_mobile.view.news.detail.tin_tuc_lien_quan.TinTucLienQuan;
import com.trang.ez_mobile.view.news.detail.tin_tuc_lien_quan.TinTucLienQuanInterface;
import com.trang.ez_mobile.view.news.detail.tin_tuc_lien_quan.TinTucLienQuanPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TraPTH on 2/22/2018.
 */

@SuppressLint("ValidFragment")
public class NewsDetailFragment extends Fragment implements NewsDetailInterface.View, TinTucLienQuanInterface.View {
    private String idTinTuc;
    private String imgTinTuc;
    private NewDetail newDetail;
    private NewsDetailInterface.Presenter presenter;

    private String folder;
    private List<TinTucLienQuan> tinTucList;
    private NewDetailAdapter adapter;
    private TinTucLienQuanInterface.Presenter tinLienQuanPresenter;

    private int check;
    //Anh xa
    private ImageView img_news_detail;
    private WebView wv_title, wv_lead, wv_body;
    private TextViewFont tv_title_tinlienquan;
    private RecyclerView lv_tin_lien_quan;
    private LinearLayout ll_progressBar, ll_detail;
    private NestedScrollView scrollview_news_detail;

    public NewsDetailFragment(String id, String img, String folder) {
        this.idTinTuc = id;
        this.imgTinTuc = img;
        this.folder = folder;
        check = 0;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);

        newDetail = new NewDetail(idTinTuc, imgTinTuc, "", "", "");

        initView(view);

        tinTucList = new ArrayList<>();
        presenter = new NewDetailPresenter(this, App.getInstance());
        presenter.callData(idTinTuc, folder);

        tinLienQuanPresenter = new TinTucLienQuanPresenter(this, getContext(), tinTucList);
        tinLienQuanPresenter.getData(folder, idTinTuc);

        check = 0;

        //keo RecyclerView trong scroll muot hon
        lv_tin_lien_quan.setNestedScrollingEnabled(false);

        tv_title_tinlienquan.setText(getString(R.string.related_news));

        return view;
    }

    private void initView(View view) {
        img_news_detail = (ImageView) view.findViewById(R.id.img_news_detail);
        wv_title = (WebView) view.findViewById(R.id.wv_title);
        wv_lead = (WebView) view.findViewById(R.id.wv_lead);
        wv_body = (WebView) view.findViewById(R.id.wv_body);
        tv_title_tinlienquan = (TextViewFont) view.findViewById(R.id.tv_title_tinlienquan);
        lv_tin_lien_quan = (RecyclerView) view.findViewById(R.id.lv_tin_lien_quan);
        ll_progressBar = (LinearLayout) view.findViewById(R.id.ll_progressBar);
        scrollview_news_detail = (NestedScrollView) view.findViewById(R.id.scrollview_news_detail);
        ll_detail= (LinearLayout) view.findViewById(R.id.ll_detail);
    }

    @Override
    public void dataDetailDone(String title, String lead, String body) {
        Log.w("NewsDetailFragment", "dataDetailDone: ");
        if (!this.newDetail.getImg().equals("")) {
            loadImg(img_news_detail, newDetail.getImg());
        } else {
            try {
                img_news_detail.setImageResource(R.drawable.icon_app);
            } catch (Exception e) {
                Log.d("NewsDetailFragment", "dataDetailDone: Lỗi hiển thị ảnh" + e.toString());
            }
        }

        String html1 = "<html><head>\n" +
                "<style>\n" +
                "div.a{\n" +
                "text-align: justify !important; \n" +
                "}\n" +
                "div d, p, STRONG, font{\n" +
                "\tfont-size: 15px !important;\n" +
                "}\n" +
                "\n" +
                "</style>\n" +
//                "<body bgcolor=\"#efeeee\"><p>\n" +
                "\n" +
                "<div class= \"a\">\n" +

                title +

                "</div>\n" +
                "</font>\n" +
                "</p></body>\n" +
                "</head>\n" +
                "</html>";

        String html2 = "<html><head>\n" +
                "<style>\n" +
                "div.a{\n" +
                "text-align: justify !important; \n" +
                "}\n" +
                "div d, p, STRONG, font{\n" +
                "\tfont-size: 15px !important;\n" +
                "}\n" +
                "\n" +
                "</style>\n" +
//                "<body bgcolor=\"#efeeee\"><p>\n" +
                "\n" +
                "<div class= \"a\">\n" +

                lead +

                "</div>\n" +
                "</font>\n" +
                "</p></body>\n" +
                "</head>\n" +
                "</html>";

        String html3 = "<html><head>\n" +
                "<style>\n" +
                "div.a{\n" +
                "text-align: justify !important; \n" +
                "}\n" +
                "div d, p, STRONG, font{\n" +
                "\tfont-size: 15px !important;\n" +
                "}\n" +
                "\n" +
                "</style>\n" +
//                "<body bgcolor=\"#efeeee\"><p>\n" +
                "\n" +
                "<div class= \"a\">\n" +

                body +

                "</div>\n" +
                "</font>\n" +
                "</p></body>\n" +
                "</head>\n" +
                "</html>";


        wv_title.loadDataWithBaseURL(null, html1, "text/html", "UTF-8", null);
        wv_lead.loadDataWithBaseURL(null, html2, "text/html", "UTF-8", null);
        wv_body.loadDataWithBaseURL(null, html3, "text/html", "UTF-8", null);

        check++;
        if (check == 2) {
            ll_progressBar.setVisibility(View.GONE);
            tv_title_tinlienquan.setVisibility(View.VISIBLE);
            ll_detail.setVisibility(View.VISIBLE);
            check = 0;
        }
    }

    @Override
    public void dataTinLienQuanDone(List<TinTucLienQuan> tinTucList) {
        Log.w("NewsDetailFragment", "dataTinLienQuanDone: ");
//        ll_progressBar.setVisibility(View.GONE);
        adapter = new NewDetailAdapter(tinTucList, App.getInstance(), folder, this);
        lv_tin_lien_quan.setAdapter(adapter);
        lv_tin_lien_quan.setLayoutManager(new LinearLayoutManager(getContext()));

        //Thêm dòng kẻ giữa các item
        lv_tin_lien_quan.addItemDecoration(new DividerItemDecoration(getContext(), 1));

        adapter.notifyDataSetChanged();

        check++;
        if (check == 2) {
            ll_progressBar.setVisibility(View.GONE);
            tv_title_tinlienquan.setVisibility(View.VISIBLE);
            ll_detail.setVisibility(View.VISIBLE);
            check = 0;
        }
    }

    @Override
    public void dataFail() {
        Log.w("NewsDetailFragment", "dataFail: ");
        tv_title_tinlienquan.setVisibility(View.GONE);
        ll_progressBar.setVisibility(View.GONE);
        Toast.makeText(getActivity(), "ErrorDatabase", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoad() {
        Log.w("NewsDetailFragment", "onLoad: ");
        ll_detail.setVisibility(View.GONE);
        ll_progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void connectFail() {
        Log.w("NewsDetailFragment", "connectFail: ");
        tv_title_tinlienquan.setVisibility(View.GONE);
        ll_progressBar.setVisibility(View.GONE);
        Toast.makeText(getActivity(), "ErrorConnect", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void moveFragment(String id, String img, String folder) {
        Log.w("NewsDetailFragment", "moveFragment: ");
//        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//        transaction.remove(this).replace(R.id.contentview, new NewsDetailFragment(id, img, folder));
//
//        transaction.addToBackStack(null);
//        transaction.commit();
        idTinTuc = id;
        newDetail.setImg(img);
        this.folder = folder;
        tinTucList.clear();

        ll_detail.setVisibility(View.GONE);
        presenter.callData(idTinTuc, this.folder);
        tinLienQuanPresenter.getData(this.folder, idTinTuc);

        //dua len tren dau
        scrollview_news_detail.scrollTo(0, 0);

    }

    @Override
    public void connectServerFail() {
        Log.w("NewsDetailFragment", "connectServerFail: ");
        tv_title_tinlienquan.setVisibility(View.GONE);
        ll_progressBar.setVisibility(View.GONE);
        Toast.makeText(getActivity(), "Error Connect Server, Check Your Network", Toast.LENGTH_SHORT).show();
    }

    public static void loadImg(ImageView imageView, String url) {
        if (!url.equals("")) {
            Glide.with(imageView.getContext())
                    .load(url)
                    .into(imageView);
        }
    }
}
