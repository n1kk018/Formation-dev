package generic.ws.util.interceptor.cxf;

import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.phase.Phase;
import org.apache.log4j.Logger;


/**
 * CXF custom Interceptor that provides log of soap message
 * (like predefined org.apache.cxf.interceptor.LoggingInInterceptor)
 */

public class CxfLogInterceptor extends AbstractSoapInterceptor {
	protected Logger log = Logger.getLogger(getClass());
	
	public CxfLogInterceptor() {
	    super(Phase.RECEIVE);  // PHASE de l'interception à préciser dans constructeur !!!!
	  }

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		InputStream is = message.getContent(InputStream.class);
        if (is != null) {
            CachedOutputStream bos = new CachedOutputStream();
            try {
                IOUtils.copy(is, bos);    bos.flush();  is.close();
                message.setContent(InputStream.class, bos.getInputStream());
                StringWriter swriter = new StringWriter();
                Transformer serializer = (TransformerFactory.newInstance()).newTransformer();
                serializer.transform(new StreamSource(bos.getInputStream()), new StreamResult(swriter));
                log.info(">>soap message received:" + swriter.toString());
                //System.out.println(">>soap message received:" + swriter.toString());
                bos.close();
            } catch (Exception e) {
                throw new Fault(e);
            }
        }
	}
}
