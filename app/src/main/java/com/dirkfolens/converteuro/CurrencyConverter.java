package com.dirkfolens.converteuro;

import android.app.Activity;
        import android.support.v7.app.ActionBarActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.TextView;

public class CurrencyConverter extends ActionBarActivity implements OnClickListener {
    TextView dollars, euros, rate;
    RadioButton dtoe, etod;
    Button convert;
    String Dollar, Euro;              // Added

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        //this.setTitle("name");

        dollars = (TextView) this.findViewById(R.id.dollars);        // attaches the variable(method) called dollars to the Textview widget called "dollars" in activity_main.xml
        euros = (TextView) this.findViewById(R.id.euros);
        rate = (TextView) this.findViewById(R.id.edRate);              // Added

        dtoe = (RadioButton) this.findViewById(R.id.rbdtoe);
        dtoe.setChecked(true);
        etod = (RadioButton) this.findViewById(R.id.rbetod);

        convert = (Button) this.findViewById(R.id.btconvert);        // attaches the variable(method) called convert to the Button widget called "btconvert" in activity_main.xml
        convert.setOnClickListener(this);                           // ?????
    }

    public void onClick(View v) {                                   // how does this get called????
        if (dtoe.isChecked()) {
            euros.setText("");              // Added does it work?
            convertDollarsToEuros();
        }
        if (etod.isChecked()) {
            convertEurosToDollars();
        }
    }

    protected void convertDollarsToEuros() {
        double val = Double.parseDouble(dollars.getText().toString());
        double exc = Double.parseDouble(rate.getText().toString());               // Added
        // in a real app, we'd get this off the 'net
        Euro = String.format("%.2f", val / exc);              // Added
        euros.setText(Euro);              // Added
    }

    protected void convertEurosToDollars() {
        double val = Double.parseDouble(euros.getText().toString());
        double exc = Double.parseDouble(rate.getText().toString());              // Added
        // in a real app, we'd get this off the 'net
        Dollar = String.format("%.2f", val * exc);              // Added
        dollars.setText(Dollar);              // Added
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_green) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}