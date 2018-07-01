package com.sportaslifestyle.ticketanimationapp;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketViewHolder> {

    private List<Ticket> mTickets;
    private Map<Integer, Boolean> mFoldStates = new HashMap<>();
    private Context mContext;

    public TicketAdapter(List<Ticket> tickets, Context context) {
        mTickets = tickets;
        mContext = context;
    }


    @NonNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TicketViewHolder(new FoldableLayout(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(@NonNull final TicketViewHolder holder, int position) {
        Ticket ticket = mTickets.get(position);
        holder.tvPrice.setText(ticket.getPrice());
        holder.tvPriceDetail.setText(ticket.getPrice());
        holder.tvTime.setText(ticket.getTime());
        holder.tvTimeDetail.setText(ticket.getTime());
        holder.tvFrom.setText(ticket.getFrom());
        holder.tvFromDetail.setText(ticket.getFrom());
        holder.tvTo.setText(ticket.getTo());
        holder.tvToDetail.setText(ticket.getTo());
        holder.tvRequestCount.setText(ticket.getRequests() + "");

// Bind state
        if (mFoldStates.containsKey(position)) {
            if (mFoldStates.get(position) == Boolean.TRUE) {

                if (!holder.mFoldableLayout.isFolded()) {
                    holder.mFoldableLayout.foldWithoutAnimation();
                }
            } else if (mFoldStates.get(position) == Boolean.FALSE) {
                if (holder.mFoldableLayout.isFolded()) {
                    holder.mFoldableLayout.unfoldWithoutAnimation();
                }
            }
        } else {
            holder.mFoldableLayout.foldWithoutAnimation();
        }

        holder.mFoldableLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.mFoldableLayout.isFolded()) {
                    holder.mFoldableLayout.unfoldWithAnimation();
                } else {

                    holder.mFoldableLayout.foldWithAnimation();
                }
            }
        });

        holder.mFoldableLayout.setFoldListener(new FoldableLayout.FoldListener() {
            @Override
            public void onUnFoldStart() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    holder.mFoldableLayout.setElevation(5);
                }
            }

            @Override
            public void onUnFoldEnd() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    holder.mFoldableLayout.setElevation(0);
                }
                mFoldStates.put(holder.getAdapterPosition(), false);
            }

            @Override
            public void onFoldStart() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    holder.mFoldableLayout.setElevation(5);
                }
            }

            @Override
            public void onFoldEnd() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    holder.mFoldableLayout.setElevation(0);
                }
                mFoldStates.put(holder.getAdapterPosition(), true);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTickets.size();
    }

    static class TicketViewHolder extends RecyclerView.ViewHolder {
        private FoldableLayout mFoldableLayout;
        private TextView tvPrice;
        private TextView tvPriceDetail;
        private TextView tvTime;
        private TextView tvTimeDetail;
        private TextView tvFrom;
        private TextView tvFromDetail;
        private TextView tvTo;
        private TextView tvToDetail;
        private TextView tvRequestCount;


        public TicketViewHolder(FoldableLayout foldableLayout) {
            super(foldableLayout);
            mFoldableLayout = foldableLayout;
            foldableLayout.setupViews(R.layout.item_ticket_cover, R.layout.item_ticket_detail, R.dimen.card_cover_height, itemView.getContext());
            tvPrice = mFoldableLayout.findViewById(R.id.tvPrice);
            tvPriceDetail = mFoldableLayout.findViewById(R.id.tvPriceDetail);
            tvTimeDetail = mFoldableLayout.findViewById(R.id.tvTimeDetail);
            tvFromDetail = mFoldableLayout.findViewById(R.id.tvFromDetail);
            tvToDetail = mFoldableLayout.findViewById(R.id.tvToDetail);
            tvTime = mFoldableLayout.findViewById(R.id.tvTime);
            tvFrom = mFoldableLayout.findViewById(R.id.tvFrom);
            tvTo = mFoldableLayout.findViewById(R.id.tvTo);
            tvRequestCount = mFoldableLayout.findViewById(R.id.tvRequestCount);


        }
    }
}
