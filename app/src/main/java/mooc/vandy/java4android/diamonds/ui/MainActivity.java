package mooc.vandy.java4android.diamonds.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import mooc.vandy.java4android.diamonds.R;

import mooc.vandy.java4android.diamonds.logic.Logic;
import mooc.vandy.java4android.diamonds.logic.LogicInterface;

/**
 * The main UI of the App.
 */
public class MainActivity 
       extends AppCompatActivity 
       implements OutputInterface {
    /**
     * String for LOGGING.
     */
    private final static String LOG_TAG =
        MainActivity.class.getCanonicalName();

    /**
     * Logic Instance.
     */
    private LogicInterface mLogic;

    /**
     * EditText that stores the output.
     */
    private TextView mOutput;

    /**
     * The Spinner (drop down selector) that you choose which size to
     * use.
     */
    private Spinner mSizeSpinner;

    /**
     * Called when the activity is starting.
     *
     * Similar to 'main' in C/C++/Standalone Java
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // required
        super.onCreate(savedInstanceState);

        // create a new 'Logic' instance.
        mLogic = new Logic(this);

        // setup the UI.
        initializeUI();
    }

    /**
     * This method sets up/gets reference to the UI components
     */
    private void initializeUI(){
        // Set the layout.
        setContentView(R.layout.activity_main);

        // Initialize the views.
        mOutput = findViewById(R.id.outputET);
        mSizeSpinner = findViewById(R.id.sizeSpinner);

        // Initialize the adapter that binds the data to the mMathSpinner widget.
        ArrayAdapter<CharSequence> mAdapter = ArrayAdapter.createFromResource(this,
                R.array.diamondSizes,
                android.R.layout.simple_spinner_item);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Associate the ArrayAdapter with the Spinner.
        mSizeSpinner.setAdapter(mAdapter);
    }

    /**
     * Called when Button is Pressed.
     *
     * @param buttonPress
     */
    public void buttonPressed(View buttonPress) {
        resetText();
        mLogic.process(Integer.parseInt(mSizeSpinner.getSelectedItem().toString()));
    }

    /**
     * Add @a string to the EditText.
     */
    private void addToEditText(String string) {
        mOutput.setText("" + mOutput.getText() + string);
    }

    /**
     * Reset the on-screen output (EditText box).
     */
    @Override
    public void resetText() {
        mOutput.setText("");
    }

    /**
     * Prints the string representation of the passed Java Object or primitive type.
     *
     * @param obj a String, int, double, float, boolean or any Java Object.
     */
    @Override
    public void print(Object obj) {
        String text = (obj != null ? obj.toString() : "null");
        addToEditText(text);
        String debug = text.replace("\n", "\\n");
        Log.d(LOG_TAG, "print(" + debug + ")");
    }
}
