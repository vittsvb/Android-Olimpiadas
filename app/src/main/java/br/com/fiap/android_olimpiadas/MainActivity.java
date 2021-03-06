package br.com.fiap.android_olimpiadas;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    //Var da Tela principal
    EditText nome;
    EditText idade;
    Spinner spinner;
    RadioGroup rgrPerido;
    RadioButton rbtPeriodo;

    //Var do Dialog
    private Dialog dialog;
    private EditText edtNomeD, edtIdadeD, edtModalidadeD, edtPeriodoD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();

    }

    public void setupUI(){
        //Setup Main
        nome = (EditText) findViewById(R.id.nome);
        idade = (EditText) findViewById(R.id.idade);
        spinner = (Spinner) findViewById(R.id.spinner);
        rgrPerido = (RadioGroup) findViewById(R.id.rgrPerido);

        //Setup Dialog
        edtNomeD = (EditText) findViewById(R.id.edtNomeD);
        edtIdadeD = (EditText) findViewById(R.id.edtIdadeD);
        edtModalidadeD = (EditText) findViewById(R.id.edtModalidadeD);
        edtPeriodoD = (EditText) findViewById(R.id.edtPeriodoD);

    }

    //Botão Reservar
    public void reservar(View view){
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.ingresso_dialog);

        //Pega item selecionado no RadioGroup
        rbtPeriodo = (RadioButton) findViewById(rgrPerido.getCheckedRadioButtonId());

        //Ligacoes com o Dialog
        edtNomeD = (EditText) dialog.findViewById(R.id.edtNomeD);
        edtIdadeD = (EditText) dialog.findViewById(R.id.edtIdadeD);
        edtModalidadeD = (EditText) dialog.findViewById(R.id.edtModalidadeD);
        edtPeriodoD = (EditText) dialog.findViewById(R.id.edtPeriodoD);


        //Tranferir da main para o Dialog
        edtNomeD.setText(nome.getText());
        edtIdadeD.setText(idade.getText());
        edtModalidadeD.setText(String.valueOf(spinner.getSelectedItem()));
        edtPeriodoD.setText(rbtPeriodo.getText());

        dialog.show();

    }

    //Botão Finalizar
    public void finalizar (View view){
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("Confimarção");
        b.setMessage("Confirmar Reversa?");

        b.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                encerrar();
            }
        });

        b.show();
    }

    //Apaga campos
    public void encerrar(){
        dialog.dismiss();
        nome.setText("");
        idade.setText("");
        rgrPerido.clearCheck();
        spinner.setSelection(0);

    }
}
