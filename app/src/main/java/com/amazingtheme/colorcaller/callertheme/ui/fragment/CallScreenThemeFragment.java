package com.amazingtheme.colorcaller.callertheme.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amazingtheme.colorcaller.R;
import com.amazingtheme.colorcaller.ads.FirebaseADHandlers.AdUtils;
import com.amazingtheme.colorcaller.callertheme.categoryui.Images;
import com.amazingtheme.colorcaller.callertheme.categoryui.KpopCategoryActivity;
import com.amazingtheme.colorcaller.callertheme.categoryui.linearCategory.kpopCategory.LinearKpopAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class CallScreenThemeFragment extends Fragment {
    private Activity activity;

    public CallScreenThemeFragment() {

    }

    RecyclerView kpop_recycler, neon_recycler, love_recycler, call_of_duty_recycler, anime_recycler, soccer_recycler, cutefunny_recycler, modern_recycler, nature_recycler, animals_recycler, christmas_recycler, trending_recycler;
    private DatabaseReference databaseReference;
    private StorageReference storageReference;
    private static final String TAG = "CallScreenThemeFragment";
    private ArrayList<Images> categories, imagesList, neonList, loveList, callofdutyList, animeList, soccerList, cutefunnyList, modernList, natureList, animalsList, christmaslist, trendingList;
    private LinearKpopAdapter imagesAdapter;
    TextView kpop_see, neon_see, love_see, call_of_duty_see, anime_see, soccer_see, cutefunny_see, modern_see, nature_see, animals_see, christmas_see, trending_see;
    LinearLayout adsView, adsView1, adsView2, adsView3, adsView4, adsView5;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = getActivity();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize database and storage references here
        databaseReference = FirebaseDatabase.getInstance().getReference();
        storageReference = FirebaseStorage.getInstance().getReference();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_call_screen_theme, container, false);

        adsView = view.findViewById(R.id.adsView);
        adsView1 = view.findViewById(R.id.adsView1);
        adsView2 = view.findViewById(R.id.adsView2);
        adsView3 = view.findViewById(R.id.adsView3);
        adsView4 = view.findViewById(R.id.adsView4);
        adsView5 = view.findViewById(R.id.adsView5);
        AdUtils.showNativeAd(requireActivity(), adsView, true);
        AdUtils.showNativeAd(requireActivity(), adsView1, true);
        AdUtils.showNativeAd(requireActivity(), adsView2, true);
        AdUtils.showNativeAd(requireActivity(), adsView3, true);
        AdUtils.showNativeAd(requireActivity(), adsView4, true);
        AdUtils.showNativeAd(requireActivity(), adsView5, true);
        kpop_see = view.findViewById(R.id.kpop_see);
        neon_see = view.findViewById(R.id.neon_see);
        love_see = view.findViewById(R.id.love_see);
        anime_see = view.findViewById(R.id.anime_see);
        call_of_duty_see = view.findViewById(R.id.call_of_duty_see);
        soccer_see = view.findViewById(R.id.soccer_see);
        cutefunny_see = view.findViewById(R.id.cutefunny_see);
        modern_see = view.findViewById(R.id.modern_see);
        nature_see = view.findViewById(R.id.nature_see);
        animals_see = view.findViewById(R.id.animals_see);
        christmas_see = view.findViewById(R.id.christmas_see);
        trending_see = view.findViewById(R.id.trending_see);
//        ExecutorService executorService = Executors.newFixedThreadPool(12);
//
//        Runnable codeBlock = new Runnable() {
//            @Override
//            public void run() {
        kpop_see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categories.add(new Images("Images"));
                Intent intent = new Intent(getActivity(), KpopCategoryActivity.class);
                intent.putParcelableArrayListExtra("categories", categories);
                startActivity(intent);
            }
        });
        trending_see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categories.add(new Images("Trending"));
                Intent intent = new Intent(getActivity(), KpopCategoryActivity.class);
                intent.putExtra("categories", categories);
                startActivity(intent);
            }
        });
        christmas_see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categories.add(new Images("Christmas"));
                Intent intent = new Intent(getActivity(), KpopCategoryActivity.class);
                intent.putExtra("categories", categories);
                startActivity(intent);
            }
        });
        animals_see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categories.add(new Images("Animals"));
                Intent intent = new Intent(getActivity(), KpopCategoryActivity.class);
                intent.putExtra("categories", categories);
                startActivity(intent);
            }
        });
        nature_see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categories.add(new Images("Nature"));
                Intent intent = new Intent(getActivity(), KpopCategoryActivity.class);
                intent.putExtra("categories", categories);
                startActivity(intent);
            }
        });
        modern_see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categories.add(new Images("Modern"));
                Intent intent = new Intent(getActivity(), KpopCategoryActivity.class);
                intent.putExtra("categories", categories);
                startActivity(intent);
            }
        });
        cutefunny_see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categories.add(new Images("CuteFunny"));
                Intent intent = new Intent(getActivity(), KpopCategoryActivity.class);
                intent.putExtra("categories", categories);
                startActivity(intent);
            }
        });
        soccer_see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categories.add(new Images("Soccer"));
                Intent intent = new Intent(getActivity(), KpopCategoryActivity.class);
                intent.putExtra("categories", categories);
                startActivity(intent);
            }
        });
        neon_see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categories.add(new Images("Neon"));
                Intent intent = new Intent(getActivity(), KpopCategoryActivity.class);
                intent.putExtra("categories", categories);
                startActivity(intent);
            }
        });
        love_see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categories.add(new Images("Love"));
                Intent intent = new Intent(getActivity(), KpopCategoryActivity.class);
                intent.putExtra("categories", categories);
                startActivity(intent);
            }
        });
        call_of_duty_see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categories.add(new Images("CallOfDuty"));
                Intent intent = new Intent(getActivity(), KpopCategoryActivity.class);
                intent.putExtra("categories", categories);
                startActivity(intent);
            }
        });
        anime_see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categories.add(new Images("Anime"));
                Intent intent = new Intent(getActivity(), KpopCategoryActivity.class);
                intent.putExtra("categories", categories);
                startActivity(intent);
            }
        });
//            }
//        };

//        executorService.submit(codeBlock);

        Log.d(TAG, "onCreate: started");
        kpop_recycler = view.findViewById(R.id.kpop_recycler);
        neon_recycler = view.findViewById(R.id.neon_recycler);
        love_recycler = view.findViewById(R.id.love_recycler);
        call_of_duty_recycler = view.findViewById(R.id.call_of_duty_recycler);
        anime_recycler = view.findViewById(R.id.anime_recycler);
        soccer_recycler = view.findViewById(R.id.soccer_recycler);
        cutefunny_recycler = view.findViewById(R.id.cutefunny_recycler);
        modern_recycler = view.findViewById(R.id.modern_recycler);
        nature_recycler = view.findViewById(R.id.nature_recycler);
        animals_recycler = view.findViewById(R.id.animals_recycler);
        christmas_recycler = view.findViewById(R.id.christmas_recycler);
        trending_recycler = view.findViewById(R.id.trending_recycler);

        kpop_recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        kpop_recycler.setHasFixedSize(true);
        neon_recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        neon_recycler.setHasFixedSize(true);
        love_recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        love_recycler.setHasFixedSize(true);
        call_of_duty_recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        call_of_duty_recycler.setHasFixedSize(true);
        anime_recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        anime_recycler.setHasFixedSize(true);
        soccer_recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        soccer_recycler.setHasFixedSize(true);
        cutefunny_recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        cutefunny_recycler.setHasFixedSize(true);
        modern_recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        modern_recycler.setHasFixedSize(true);
        nature_recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        nature_recycler.setHasFixedSize(true);
        animals_recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        animals_recycler.setHasFixedSize(true);
        christmas_recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        christmas_recycler.setHasFixedSize(true);
        trending_recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        trending_recycler.setHasFixedSize(true);


        categories = new ArrayList<>();
        imagesList = new ArrayList<>();
        neonList = new ArrayList<>();
        loveList = new ArrayList<>();
        callofdutyList = new ArrayList<>();
        animeList = new ArrayList<>();
        soccerList = new ArrayList<>();
        cutefunnyList = new ArrayList<>();
        modernList = new ArrayList<>();
        natureList = new ArrayList<>();
        animalsList = new ArrayList<>();
        christmaslist = new ArrayList<>();
        trendingList = new ArrayList<>();

        neon();
        love();
        callofDuty();
        anime();
        soccer();
        cuteFunny();
        modern();
        nature();
        animals();
        christmas();
        trending();
        init();


        return view;
    }

    private void trending() {
        clearAllTrending();
        Query query = databaseReference.child("Trending");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    Images images = new Images();
                    images.setUrl(snapshot.child("url").getValue().toString());
                    trendingList.add(images);
                }
                imagesAdapter = new LinearKpopAdapter(getActivity(), trendingList);
                trending_recycler.setAdapter(imagesAdapter);
                imagesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void christmas() {
        clearAllChristmas();
        Query query = databaseReference.child("Christmas");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    Images images = new Images();
                    images.setUrl(snapshot.child("url").getValue().toString());
                    christmaslist.add(images);
                }
                imagesAdapter = new LinearKpopAdapter(getActivity(), christmaslist);
                christmas_recycler.setAdapter(imagesAdapter);
                imagesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void animals() {
        clearAllAnimals();
        Query query = databaseReference.child("Animals");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    Images images = new Images();
                    images.setUrl(snapshot.child("url").getValue().toString());
                    animalsList.add(images);
                }
                imagesAdapter = new LinearKpopAdapter(getActivity(), animalsList);
                animals_recycler.setAdapter(imagesAdapter);
                imagesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void nature() {
        clearAllNature();
        Query query = databaseReference.child("Nature");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    Images images = new Images();
                    images.setUrl(snapshot.child("url").getValue().toString());
                    natureList.add(images);
                }
                imagesAdapter = new LinearKpopAdapter(getActivity(), natureList);
                nature_recycler.setAdapter(imagesAdapter);
                imagesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void modern() {
        clearAllModern();
        Query query = databaseReference.child("Modern");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    Images images = new Images();
                    images.setUrl(snapshot.child("url").getValue().toString());
                    modernList.add(images);
                }
                imagesAdapter = new LinearKpopAdapter(getActivity(), modernList);
                modern_recycler.setAdapter(imagesAdapter);
                imagesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void cuteFunny() {
        clearAllCuteFunny();
        Query query = databaseReference.child("CuteFunny");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    Images images = new Images();
                    images.setUrl(snapshot.child("url").getValue().toString());
                    cutefunnyList.add(images);
                }
                imagesAdapter = new LinearKpopAdapter(getActivity(), cutefunnyList);
                cutefunny_recycler.setAdapter(imagesAdapter);
                imagesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void soccer() {
        clearAllSoccer();
        Query query = databaseReference.child("Soccer");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    Images images = new Images();
                    images.setUrl(snapshot.child("url").getValue().toString());
                    soccerList.add(images);
                }
                imagesAdapter = new LinearKpopAdapter(getActivity(), soccerList);
                soccer_recycler.setAdapter(imagesAdapter);
                imagesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void anime() {
        clearAllAnime();
        Query query = databaseReference.child("Anime");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    Images images = new Images();
                    images.setUrl(snapshot.child("url").getValue().toString());
                    animeList.add(images);
                }
                imagesAdapter = new LinearKpopAdapter(getActivity(), animeList);
                anime_recycler.setAdapter(imagesAdapter);
                imagesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void callofDuty() {
        clearAllCallOfDuty();
        Query query = databaseReference.child("CallOfDuty");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    Images images = new Images();
                    images.setUrl(snapshot.child("url").getValue().toString());
                    callofdutyList.add(images);
                }
                imagesAdapter = new LinearKpopAdapter(getActivity(), callofdutyList);
                call_of_duty_recycler.setAdapter(imagesAdapter);
                imagesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void love() {
        clearAlllove();
        Query query = databaseReference.child("Love");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    Images images = new Images();
                    images.setUrl(snapshot.child("url").getValue().toString());
                    loveList.add(images);
                }
                imagesAdapter = new LinearKpopAdapter(getActivity(), loveList);
                love_recycler.setAdapter(imagesAdapter);
                imagesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void neon() {
        clearAllneon();
        Query query = databaseReference.child("Neon");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    Images images = new Images();
                    images.setUrl(snapshot.child("url").getValue().toString());
                    neonList.add(images);
                }
                imagesAdapter = new LinearKpopAdapter(getActivity(), neonList);
                neon_recycler.setAdapter(imagesAdapter);
                imagesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void init() {
        clearAll();
        Query query = databaseReference.child("Images");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    Images images = new Images();
                    images.setUrl(snapshot.child("url").getValue().toString());
                    imagesList.add(images);
                }
                imagesAdapter = new LinearKpopAdapter(getActivity(), imagesList);
                kpop_recycler.setAdapter(imagesAdapter);
                imagesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void clearAll() {
        if (imagesList != null) {
            imagesList.clear();
            if (imagesAdapter != null) {
                imagesAdapter.notifyDataSetChanged();
            }
        }
        imagesList = new ArrayList<>();
    }

    private void clearAllneon() {
        if (neonList != null) {
            neonList.clear();
            if (imagesAdapter != null) {
                imagesAdapter.notifyDataSetChanged();
            }
        }
        neonList = new ArrayList<>();
    }

    private void clearAlllove() {
        if (loveList != null) {
            loveList.clear();
            if (imagesAdapter != null) {
                imagesAdapter.notifyDataSetChanged();
            }
        }
        loveList = new ArrayList<>();
    }

    private void clearAllCallOfDuty() {
        if (callofdutyList != null) {
            callofdutyList.clear();
            if (imagesAdapter != null) {
                imagesAdapter.notifyDataSetChanged();
            }
        }
        callofdutyList = new ArrayList<>();
    }

    private void clearAllAnime() {
        if (animeList != null) {
            animeList.clear();
            if (imagesAdapter != null) {
                imagesAdapter.notifyDataSetChanged();
            }
        }
        animeList = new ArrayList<>();
    }

    private void clearAllCuteFunny() {
        if (cutefunnyList != null) {
            cutefunnyList.clear();
            if (imagesAdapter != null) {
                imagesAdapter.notifyDataSetChanged();
            }
        }
        cutefunnyList = new ArrayList<>();
    }

    private void clearAllSoccer() {
        if (soccerList != null) {
            soccerList.clear();
            if (imagesAdapter != null) {
                imagesAdapter.notifyDataSetChanged();
            }
        }
        soccerList = new ArrayList<>();
    }

    private void clearAllModern() {
        if (modernList != null) {
            modernList.clear();
            if (imagesAdapter != null) {
                imagesAdapter.notifyDataSetChanged();
            }
        }
        modernList = new ArrayList<>();
    }

    private void clearAllNature() {
        if (natureList != null) {
            natureList.clear();
            if (imagesAdapter != null) {
                imagesAdapter.notifyDataSetChanged();
            }
        }
        natureList = new ArrayList<>();
    }

    private void clearAllAnimals() {
        if (animalsList != null) {
            animalsList.clear();
            if (imagesAdapter != null) {
                imagesAdapter.notifyDataSetChanged();
            }
        }
        animalsList = new ArrayList<>();
    }

    private void clearAllChristmas() {
        if (christmaslist != null) {
            christmaslist.clear();
            if (imagesAdapter != null) {
                imagesAdapter.notifyDataSetChanged();
            }
        }
        christmaslist = new ArrayList<>();
    }

    private void clearAllTrending() {
        if (trendingList != null) {
            trendingList.clear();
            if (imagesAdapter != null) {
                imagesAdapter.notifyDataSetChanged();
            }
        }
        trendingList = new ArrayList<>();
    }
}