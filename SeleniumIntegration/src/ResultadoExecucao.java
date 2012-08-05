import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
public class ResultadoExecucao implements IConstantes {
public static void reportTestCaseResult1(String projetoTeste, String planoTeste, String casoTeste, String nomeBuild, String nota, String resultado) throws TestLinkAPIException {
TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(DEVKEY, URL);
testlinkAPIClient.reportTestCaseResult(projetoTeste, planoTeste, casoTeste, nomeBuild, nota, resultado);
}
}