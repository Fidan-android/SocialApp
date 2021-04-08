package com.example.socialapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socialapp.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private Context context;

//    По ее мнению, от появления доступных для понимания банковских, правовых, социальных документов,
//    инструкций к бытовым приборам, схем передвижения по городу, меню в кафе и многого другого выигрывают не только люди с инвалидностью.
//    Подобный перевод пригодится и другим категориям — пожилым горожанам с возрастными изменениями, иностранным гостям,
//    плохо знающим русский язык.
    private final ArrayList<String> posts = new ArrayList<String>();
    private final ArrayList<String> acounts = new ArrayList<String>();

    public PostsAdapter(Context context){
        this.context = context;
        posts.add("Подскажите как пройти в дом культуры там мероприятие должно быть сегодня");
        posts.add("в какой ресторан сходить и что лучше заказать чтобы покушать домашнего");
        posts.add("помогите разобрать инструкцию к А прибору");
        posts.add("подскажите есть ли парковка для инвалидов в месте Х");
        posts.add("Help translate the text: ***.");

        acounts.add("Третьякова Анастасия");
        acounts.add("Киршин Ришат");
        acounts.add("Одухова Татьяна");
        acounts.add("Рогозин Семен");
        acounts.add("Johny Lua");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.post_item, parent, false);
        return new PostsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.post.setOnClickListener((v) -> {
            Snackbar.make(v, "Вы нажали на пост", Snackbar.LENGTH_SHORT).show();
        });
        holder.profile_name.setText(acounts.get(position));

        String temp = posts.get(position).length() > 50 ? posts.get(position).substring(0, 50) + "..." : posts.get(position);
        holder.main_text.setText(temp);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout post;
        ImageView avatar;
        TextView profile_name;
        TextView main_text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            post = itemView.findViewById(R.id.post);
            avatar = itemView.findViewById(R.id.avatar);
            profile_name = itemView.findViewById(R.id.profile_name);
            main_text = itemView.findViewById(R.id.main_text);
        }
    }
}
