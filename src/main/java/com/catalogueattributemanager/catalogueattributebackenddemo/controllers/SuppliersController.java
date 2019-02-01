package com.catalogueattributemanager.catalogueattributebackenddemo.controllers;

import com.catalogueattributemanager.catalogueattributebackenddemo.models.Supplier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"http://ew1-dev.sci-ware-customer.com","http://localhost:4200"})
@RestController
@RequestMapping(value = "/suppliers")
public class SuppliersController {

    private List<Supplier> suppliers = new ArrayList<>();

    SuppliersController() {
        this.suppliers = buildSuppliers();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Supplier> getSuppliers() {
        return this.suppliers;
    }

    List<Supplier> buildSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();

        Supplier supplier1 = buildSupplier(1L, "Supplier 1");
        Supplier supplier2 = buildSupplier(2L, "Supplier 2");
        Supplier supplier3 = buildSupplier(3L, "Supplier 3");
        Supplier supplier4 = buildSupplier(4L, "Supplier 4");
        Supplier supplier5 = buildSupplier(5L, "Supplier 5");
        Supplier supplier6 = buildSupplier(6L, "Supplier 6");

        suppliers.add(supplier1);
        suppliers.add(supplier2);
        suppliers.add(supplier3);
        suppliers.add(supplier4);
        suppliers.add(supplier5);
        suppliers.add(supplier6);

        return suppliers;
    }

    Supplier buildSupplier(Long id, String name) {
        Supplier supplier = new Supplier();
        supplier.setId(id);
        supplier.setName(name);
        return supplier;
    }
}
