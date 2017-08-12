package domainapp.appdefn.services.homepage.docfragment;

import java.util.List;

import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.Nature;
import org.apache.isis.applib.services.i18n.TranslatableString;

import org.incode.domainapp.example.dom.demo.dom.customer.DemoCustomer;
import org.incode.domainapp.example.dom.demo.dom.customer.DemoCustomerRepository;
import org.incode.domainapp.example.dom.demo.dom.invoice.DemoInvoice;
import org.incode.domainapp.example.dom.demo.dom.invoice.DemoInvoiceRepository;
import org.incode.module.docfragment.dom.impl.DocFragment;
import org.incode.module.docfragment.dom.impl.DocFragmentRepository;

@DomainObject(
        nature = Nature.VIEW_MODEL,
        objectType = "domainapp.appdefn.services.homepage.docfragment.HomePageViewModel"
)
public class HomePageViewModel {

    public TranslatableString title() {
        return TranslatableString.tr("{num} doc fragments", "num", getDocFragmentObjects().size());
    }

    public List<DocFragment> getDocFragmentObjects() {
        return docfragmentRepository.listAll();
    }

    public List<DemoCustomer> getDemoCustomers() {
        return demoCustomerRepository.listAll();
    }

    public List<DemoInvoice> getDemoInvoice() {
        return demoInvoiceRepository.listAll();
    }

    @javax.inject.Inject
    DocFragmentRepository docfragmentRepository;

    @javax.inject.Inject
    DemoCustomerRepository demoCustomerRepository;

    @javax.inject.Inject
    DemoInvoiceRepository demoInvoiceRepository;


}