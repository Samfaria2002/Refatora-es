package MainRefatorado.Lista04;

import javax.swing.JOptionPane;

public class ValidaNota implements InterfaceLeituraValidacao {
    
    private int nota;
    private String resp = null;
    private boolean repetir = true;

    
    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String getResposta() {
        // TODO Auto-generated method stub
        return resp;
    }

    @Override
    public void validacao() {
        resp = JOptionPane.showInputDialog("Infome a nota [0, 10]", 0);
    }

    @Override
    public void leitura() {
        do {
            // Verifica se o botão "cancelar foi pressionado."
            if (resp == null) {
                System.err.println("Aviso: o botão \"cancelar\" foi pressionado.");
            
                System.exit(1);
            }
            try {
                nota = Integer.parseInt(resp);
                if (nota >= 0 && nota <= 10) {
                    repetir = false;
                } else {
                    repetir = true;
                }
            } catch (NumberFormatException e) {
                System.err.println("ERRO: número não identificado.");
                repetir = true;
            }
        } while (repetir == true);
        
    }
}
