package com.universityofalabama.cs495f2018.berthaIRT.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.universityofalabama.cs495f2018.berthaIRT.Client;
import com.universityofalabama.cs495f2018.berthaIRT.R;
import com.universityofalabama.cs495f2018.berthaIRT.Report;
import com.universityofalabama.cs495f2018.berthaIRT.Util;


public class StudentReportDetailsFragment extends Fragment {
    View v;

    TextView tvReportId, tvStatus, tvCreateTimestamp, tvLastActionTimestamp, tvIncidentTimestamp, tvThreat, tvDescription, tvLocation;

    public StudentReportDetailsFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater flater, ViewGroup tainer, Bundle savedInstanceState){
        v = flater.inflate(R.layout.fragment_student_reportdetails, tainer, false);

        //Get the required views
        tvReportId = v.findViewById(R.id.student_reportdetails_alt_id);
        tvStatus = v.findViewById(R.id.student_reportdetails_alt_status);
        tvCreateTimestamp = v.findViewById(R.id.student_reportdetails_alt_creationdate);
        tvLastActionTimestamp = v.findViewById(R.id.student_reportdetails_alt_lastaction);
        tvIncidentTimestamp = v.findViewById(R.id.student_reportdetails_alt_incidentdate);
        tvThreat = v.findViewById(R.id.student_reportdetails_alt_threat);
        tvDescription = v.findViewById(R.id.student_reportdetails_alt_description);
        tvLocation = v.findViewById(R.id.student_reportdetails_alt_location);

        //set the media listener
        v.findViewById(R.id.student_reportdetails_button_attachments).setOnClickListener(v1 ->
            Toast.makeText(getActivity(),"View Media", Toast.LENGTH_SHORT).show() );

        return v;
    }

    @Override
    public void onResume(){
        super.onResume();
        updateReportDisplay(Client.activeReport);
    }

    private void updateReportDisplay(Report r) {
        tvReportId.setText(r.reportId);
        tvCreateTimestamp.setText(Util.formatTimestamp(r.creationTimestamp));
        tvLastActionTimestamp.setText(Util.formatTimestamp(r.lastActionTimestamp));
        tvStatus.setText(r.status);
        tvIncidentTimestamp.setText(r.incidentTimeStamp);

        String threatString = r.threatLevel + "/5";
        tvThreat.setText(threatString);

        tvDescription.setText(r.description);
        tvLocation.setText(r.location);

        LinearLayout catTainer = v.findViewById(R.id.student_reportdetails_container_categories);
        catTainer.removeAllViews();
        for(String cat : r.categories) {
            View v = getLayoutInflater().inflate(R.layout.adapter_category, null, false);
            ((TextView) v.findViewById(R.id.adapter_alt_category)).setText(cat);
            catTainer.addView(v);
        }
    }
}
