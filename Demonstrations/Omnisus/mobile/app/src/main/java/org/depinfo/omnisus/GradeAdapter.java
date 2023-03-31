package org.depinfo.omnisus;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.depinfo.omnisus.http.dto.GradeResponse;

import java.util.ArrayList;
import java.util.List;

public class GradeAdapter extends RecyclerView.Adapter<GradeAdapter.MyViewHolder> {
    public List<GradeResponse> list;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvGrade;

        public MyViewHolder(ConstraintLayout v) {
            super(v);
            tvName = v.findViewById(R.id.tvName);
            tvGrade = v.findViewById(R.id.tvGrade);
        }
    }

    public GradeAdapter() {
        list = new ArrayList<>();
    }

    @Override
    public GradeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grade_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        GradeResponse grade = list.get(position);
        holder.tvName.setText("- " + grade.name + " : ");
        holder.tvGrade.setText(grade.grade + " %");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}