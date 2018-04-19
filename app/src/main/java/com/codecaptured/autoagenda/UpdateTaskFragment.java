//package com.codecaptured.autoagenda;
//
//import android.app.AlertDialog;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.net.Uri;
//import android.os.Build;
//import android.os.Bundle;
//import android.support.v4.app.DialogFragment;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Spinner;
//import android.widget.TextView;
//import android.widget.TimePicker;
//
//import com.codecaptured.autoagendacore.usecases.TaskInteractor;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//
///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link UpdateTaskFragment.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link UpdateTaskFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
//public class UpdateTaskFragment extends DialogFragment
//{
//	// TODO: Rename parameter arguments, choose names that match
//	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//	private static final String titleArg = "param1";
//	private static final String dateArg = "param2";
//	private static final String dateArg = "param2";
//
//	/** The rootview from Main */
//	View RootView;
//
//	/** Log tag. */
//	private static final String LOG_TAG = UpdateTaskFragment.class.getSimpleName();
//
//	/** The code to open date picker dialog */
//	private static final int DATEINIT_DIALOG = 999;
//
//	// TODO: Rename and change types of parameters
//	private String mParam1;
//	private String mParam2;
//
//	private OnFragmentInteractionListener mListener;
//
//	public static TextView testTextView;
//
//	/** The edittext used to select the task name */
//	private EditText taskEditText;
//
//	/** The edittext used to select the description name */
//	private EditText descriptionEditText;
//
//	/** The edittext used to select the task date */
//	private EditText dateEditText;
//	Date selectedDate;
//	String selectedTime;
//
//	/** The edittext used to select the task time */
//	private EditText timeEditText;
//
//	/** The edittext used to select the task required time */
//	private EditText timeRequiredEditText;
//
//	/** Calendar instance */
//	Calendar calendar = Calendar.getInstance();
//
//	/** Repeat spinner */
//	Spinner repeatSpinner;
//
//	/** Priority spinner */
//	Spinner prioritySpinner;
//
//	/** Reminder spinner */
//	Spinner reminderSpinner;
//
//	/** Cancel Button */
//	Button cancelButton;
//
//	/** ADd Button */
//	Button addButton;
//
//
//	/** Date picker dialog */
//	android.app.DatePickerDialog.OnDateSetListener date;
//
//	public UpdateTaskFragment()
//	{
//		// Required empty public constructor
//	}
//
//	/**
//	 * Use this factory method to create a new instance of
//	 * this fragment using the provided parameters.
//	 *
//	 * @param param1 Parameter 1.
//	 * @param param2 Parameter 2.
//	 * @return A new instance of fragment taskFragment.
//	 */
//	// TODO: Rename and change types and number of parameters
//	public static UpdateTaskFragment newInstance(String param1, String param2)
//	{
//		UpdateTaskFragment fragment = new UpdateTaskFragment();
//		Bundle args = new Bundle();
//		args.putString(ARG_PARAM1, param1);
//		args.putString(ARG_PARAM2, param2);
//		fragment.setArguments(args);
//		return fragment;
//	}
//
//	@Override
//	public void onCreate(Bundle savedInstanceState)
//	{
//		super.onCreate(savedInstanceState);
//		if (getArguments() != null)
//		{
//			mParam1 = getArguments().getString(ARG_PARAM1);
//			mParam2 = getArguments().getString(ARG_PARAM2);
//		}
//
//	}
//
//	@Override
//	public View onCreateView(LayoutInflater inflater, ViewGroup container,
//	                         Bundle savedInstanceState)
//	{
//		// Inflate the layout for this fragment
//		RootView = inflater.inflate(R.layout.fragment_update_task, container, false);
//		//		testTextView = (android.widget.TextView) RootView.findViewById(com.codecaptured.autoagenda.R.id.textView);
//		//		testTextView.setText(mParam2);
//		dateEditText = (EditText) RootView.findViewById(R.id.dateEditText);
//		timeEditText = (EditText) RootView.findViewById(R.id.timeEditText);
//
//		taskEditText = (EditText) RootView.findViewById(R.id.taskEditText);
//		timeRequiredEditText = (EditText) RootView.findViewById(R.id.timeRequiredEditText);
//		descriptionEditText = (EditText) RootView.findViewById(R.id.descriptionEditText);
//
//		dateEditText.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View v)
//			{
//				new android.app.DatePickerDialog(getContext(), date, calendar
//								.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
//								calendar.get(Calendar.DAY_OF_MONTH)).show();
//
//				Calendar mcurrentTime = Calendar.getInstance();
//				int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
//				int minute = mcurrentTime.get(Calendar.MINUTE);
//				android.app.TimePickerDialog mTimePicker;
//				mTimePicker = new android.app.TimePickerDialog(getContext(), new android.app.TimePickerDialog.OnTimeSetListener() {
//					@Override
//					public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
//						calendar.set(Calendar.HOUR, selectedHour);
//						calendar.set(Calendar.MINUTE, selectedMinute);
//					}
//				}, hour, minute, false);//Yes 24 hour time
//				mTimePicker.show();
//			}
//		});
//
//		date = new android.app.DatePickerDialog.OnDateSetListener() {
//
//			@Override
//			public void onDateSet(android.widget.DatePicker view, int year, int monthOfYear,
//			                      int dayOfMonth) {
//				// TODO Auto-generated method stub
//				calendar.set(Calendar.YEAR, year);
//				calendar.set(Calendar.MONTH, monthOfYear);
//				calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//				updateDate();
//				selectedDate = calendar.getTime();
//			}
//
//		};
//
////		timeEditText.setOnClickListener(new android.view.View.OnClickListener() {
////
////			@Override
////			public void onClick(View v) {
////				// TODO Auto-generated method stub
////				java.util.Calendar mcurrentTime = java.util.Calendar.getInstance();
////				int hour = mcurrentTime.get(java.util.Calendar.HOUR_OF_DAY);
////				int minute = mcurrentTime.get(java.util.Calendar.MINUTE);
////				android.app.TimePickerDialog mTimePicker;
////				mTimePicker = new android.app.TimePickerDialog(getContext(), new android.app.TimePickerDialog.OnTimeSetListener() {
////					@Override
////					public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
////						timeEditText.setText( selectedHour + ":" + selectedMinute);
////					}
////				}, hour, minute, false);//Yes 24 hour time
////				mTimePicker.setTitle("Select Time");
////				mTimePicker.show();
////
////			}
////		});
//
////		// Setup repeat spinner
////		repeatSpinner = (Spinner) RootView.findViewById(R.id.repeatSpinner);
////		ArrayAdapter<CharSequence> repeatAdapter = ArrayAdapter.createFromResource(RootView.getContext(), R.array.repeatSpinnerArray, android.R.layout.simple_spinner_item);
////		repeatSpinner.setAdapter(repeatAdapter);
//
//		// Setup priority spinner
//		prioritySpinner = (Spinner) RootView.findViewById(R.id.prioritySpinner);
//		ArrayAdapter<CharSequence> priorityAdapter = ArrayAdapter.createFromResource(RootView.getContext(), R.array.prioritySpinnerArray, android.R.layout.simple_spinner_item);
//		prioritySpinner.setAdapter(priorityAdapter);
//
////		// Setup reminder spinner
////		reminderSpinner = (Spinner) RootView.findViewById(R.id.reminderSpinner);
////		ArrayAdapter<CharSequence> reminderAdapter = ArrayAdapter.createFromResource(RootView.getContext(), R.array.reminderSpinnerArray, android.R.layout.simple_spinner_item);
////		reminderSpinner.setAdapter(reminderAdapter);
//
//		// Setup cancel button
//		cancelButton = (Button) RootView.findViewById(R.id.cancelButton);
//		cancelButton.setOnClickListener(new View.OnClickListener()
//		{
//			@Override
//			public void onClick(View view)
//			{
//				cancelButtonClicked(view);
//			}
//		});
//
//		addButton = (Button) RootView.findViewById(R.id.addUpdateButton);
//		addButton.setOnClickListener(new View.OnClickListener()
//		{
//			@Override
//			public void onClick(View view)
//			{
//				addButtonClicked(view);
//			}
//		});
//
//		return RootView;
//	}
//
//	// TODO: Rename method, update argument and hook method into UI event
//	public void onButtonPressed(Uri uri)
//	{
//		if (mListener != null)
//		{
//			mListener.onFragmentInteraction(uri);
//		}
//	}
//
//	@Override
//	public void onAttach(Context context)
//	{
//		super.onAttach(context);
//		if (context instanceof OnFragmentInteractionListener)
//		{
//			mListener = (OnFragmentInteractionListener) context;
//		} else
//		{
//			throw new RuntimeException(context.toString()
//							+ " must implement OnFragmentInteractionListener");
//		}
//	}
//
//	@Override
//	public void onDetach()
//	{
//		super.onDetach();
//		mListener = null;
//	}
//
//	/**
//	 * This interface must be implemented by activities that contain this
//	 * fragment to allow an interaction in this fragment to be communicated
//	 * to the activity and potentially other fragments contained in that
//	 * activity.
//	 * <p>
//	 * See the Android Training lesson <a href=
//	 * "http://developer.android.com/training/basics/fragments/communicating.html"
//	 * >Communicating with Other Fragments</a> for more information.
//	 */
//	public interface OnFragmentInteractionListener
//	{
//		// TODO: Update argument type and name
//		void onFragmentInteraction(Uri uri);
//	}
//
//	public void setDate(View view) {
//		new android.app.DatePickerDialog(getContext(), date, calendar
//						.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
//						calendar.get(Calendar.DAY_OF_MONTH)).show();
//	}
//
//	private void updateDate() {
//		String myFormat = "MM/dd/yy hh:mm aa";
//		SimpleDateFormat sdf = new SimpleDateFormat(myFormat, java.util.Locale.US);
//
//		dateEditText.setText(sdf.format(calendar.getTime()));
//	}
//
//	public void addButtonClicked(View view){
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
//		Date tempDate1 = new Date();
//		Date tempDate2 = new Date();
//		Date tempDate3 = new Date();
//		Date tempDate4 = new Date();
//		Date tempDate5 = new Date();
//		Date tempDate6 = new Date();
//		Date tempDate7 = new Date();
//		Date tempDate8 = new Date();
//		Date tempDate9 = new Date();
//		Date tempDate10 = new Date();
//
//		try
//		{
//			tempDate1 = sdf.parse("13/9/2018 12:00:00");
//			tempDate2 = sdf.parse("13/8/2018 12:00:00");
//			tempDate3 = sdf.parse("13/7/2018 12:00:00");
//			tempDate4 = sdf.parse("13/6/2018 12:00:00");
//			tempDate5 = sdf.parse("13/5/2018 12:00:00");
//			tempDate6 = sdf.parse("13/10/2018 12:00:00");
//			tempDate7 = sdf.parse("13/11/2018 12:00:00");
//			tempDate8 = sdf.parse("13/12/2018 12:00:00");
//			tempDate9 = sdf.parse("11/12/2018 12:00:00");
//			tempDate10 = sdf.parse("22/7/2018 12:00:00");
//		}
//		catch (ParseException e)
//		{
//			e.printStackTrace();
//		}
//
//		String[] tempTags  = {"work"};
//		String[] tempTags2  = {"school", "gym"};
//
//		if(postIsProper() == true && dateIsProper(selectedDate) == true)
//		{
//			UserTask tempTask1 = new UserTask(taskEditText.getText().toString(), "" + descriptionEditText.getText().toString(), false, selectedDate, Integer.parseInt(timeRequiredEditText.getText().toString()), prioritySpinner.getSelectedItemPosition() + 1, tempTags2);
//			TaskInteractor.addTask(tempTask1);
//			for(int i = 0; i < tempTask1.timeBlocks.length; i++){
//				UserTask temp = tempTask1;
//				temp.thisTimeBlock = temp.timeBlocks[i];
//				ListFragment.finalTaskList.add(temp);
//			}
//			//ListFragment.finalTaskList.add(tempTask1);
//			ListFragment.mAdapter.notifyDataSetChanged();
//			dismiss();
//		}
////		UserTask tempTask2 = new UserTask("Temp2", "Hello", false, tempDate2, 15, 2, tempTags);
////		UserTask tempTask3 = new UserTask("Temp3", "Hello", false, tempDate3, 20, 1, tempTags);
////		UserTask tempTask4 = new UserTask("Temp4", "Hello", false, tempDate4, 60, 2, tempTags);
////		UserTask tempTask5 = new UserTask("Temp5", "Hello", false, tempDate5, 100, 3, tempTags);
////		UserTask tempTask6 = new UserTask("Temp6", "Hello", false, tempDate6, 15, 1, tempTags);
////		UserTask tempTask7 = new UserTask("Temp7", "Hello", false, tempDate7, 120, 3, tempTags);
////		UserTask tempTask8 = new UserTask("Temp8", "Hello", false, tempDate8, 20, 2, tempTags2);
////		UserTask tempTask9 = new UserTask("Temp9", "Hello", false, tempDate9, 60, 1, tempTags2);
////		UserTask tempTask10 = new UserTask("Temp10", "Hello", false, tempDate10, 120, 3, tempTags2);
////
////		ListFragment.finalTaskList.add(tempTask1);
////		ListFragment.finalTaskList.add(tempTask2);
////		ListFragment.finalTaskList.add(tempTask3);
////		ListFragment.finalTaskList.add(tempTask4);
////		ListFragment.finalTaskList.add(tempTask5);
////		ListFragment.finalTaskList.add(tempTask6);
////		ListFragment.finalTaskList.add(tempTask7);
////		ListFragment.finalTaskList.add(tempTask8);
////		ListFragment.finalTaskList.add(tempTask9);
////		ListFragment.finalTaskList.add(tempTask10);
//
//
//		else{
//			AlertDialog.Builder builder;
//			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//				builder = new AlertDialog.Builder(RootView.getContext(), android.R.style.Theme_Material_Dialog_Alert);
//			} else {
//				builder = new AlertDialog.Builder(RootView.getContext());
//			}
//			builder.setTitle("Oops!")
//							.setMessage("All required fields must be filled. Selected time cannot be in the past.")
//							.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//								public void onClick(DialogInterface dialog, int which) {
//
//								}
//							})
//							.show();
//		}
//
//
//		//		TaskInteractor.addTask(tempTask1);
////		TaskInteractor.addTask(tempTask2);
////		TaskInteractor.addTask(tempTask3);
////		TaskInteractor.addTask(tempTask4);
////		TaskInteractor.addTask(tempTask5);
////		TaskInteractor.addTask(tempTask6);
////		TaskInteractor.addTask(tempTask7);
////		TaskInteractor.addTask(tempTask8);
////		TaskInteractor.addTask(tempTask9);
////		TaskInteractor.addTask(tempTask10);
//
//		//System.out.println("Tasks have been added");
//
//		// TODO: Create a notification (just use the Task ID for nwo)
//
//	}
//
//	public void cancelButtonClicked(View view){
//		dismiss();
//	}
//
//	public boolean postIsProper(){
//		boolean isProper = true;
//		if (taskEditText.getText().toString().equals("") || timeRequiredEditText.getText().toString().equals("") || dateEditText.getText().toString().equals("") ||
//						taskEditText.getText().toString().equals(null) || timeRequiredEditText.getText().toString().equals(null) || dateEditText.getText().toString().equals(null))
//		{
//			isProper = false;
//		}
//
//		return isProper;
//	}
//
//	public boolean dateIsProper(Date date){
//		boolean isProper = true;
//
//		Date today = Calendar.getInstance().getTime();
//
//		if(date.before(today)){
//			isProper = false;
//		}
//
//
//		return isProper;
//
//	}
//}
//
//
//