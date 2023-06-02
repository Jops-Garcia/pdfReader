import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;


public class App {
    public static void main(String[] args) throws Exception {
        Account account = new Account();
        Payment payment = new Payment();
        Statement statement = new Statement();
        Transaction transaction = new Transaction();


        String mydir = System.getProperty("user.dir");
        mydir = mydir + "\\src\\";
        //Entrada manual
        // ALTERE O NOME DO ARQUIVO AQUI -> | <- CHANGE FILE NAME HERE
                                        //  V
        String ArqConfig = mydir + "documento_teste_dev.pdf"; //Deixe o arquivo dentro da pasta src ou altere a variavel "mydir"
        
        File file = new File(ArqConfig);

        try (PDDocument document = Loader.loadPDF(file)) {

            if (!document.isEncrypted()) {
			
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);

                String lines[] = pdfFileInText.split("\\r?\\n");
                for (String line : lines) {
                   //searching each line for data
                    account.search(line);
                    statement.search(line);
                    payment.search(line);
                    transaction.search(line);
                    

                }
                System.out.printf("\n\n|-----------------------Identificação no extrato----------------------|\n");
                System.out.printf(" Identificação: %s                                                       \n", statement.getId());
                System.out.printf("\n|------------------------Dados da conta debitada----------------------|\n");
                System.out.printf(" Nome: %s                                                                \n", account.getName());
                System.out.printf(" Agência: %s                                                             \n", account.getAgency());
                System.out.printf(" Conta: %s                                                               \n", account.getNumber());
                System.out.printf("\n|---------------------------Dados do pagamento------------------------|\n");
                System.out.printf(" Código de barras: %s                                                    \n", payment.getCode());
                System.out.printf(" Valor do documento: %s                                                  \n", payment.getValue());
                System.out.printf(" Informações fornecidas pelo pagador: %s                                 \n", payment.getInfo());
                System.out.printf("\n|---------------------------Data da operação--------------------------|\n");
                System.out.printf(" Data: %s                                                                \n", transaction.getDate());
                System.out.printf("\n|---------------------------------------------------------------------|\n");
            }
        }
    }
}
