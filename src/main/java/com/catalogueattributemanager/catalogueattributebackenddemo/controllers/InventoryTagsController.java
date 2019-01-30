package com.catalogueattributemanager.catalogueattributebackenddemo.controllers;

import com.catalogueattributemanager.catalogueattributebackenddemo.models.InventoryTag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/inventory-tags")
public class InventoryTagsController {

    private List<InventoryTag> inventoryTags = new ArrayList<>();

    InventoryTagsController() {
        this.inventoryTags = buildInventoryTags();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<InventoryTag> getInventoryTags() {
        return this.inventoryTags;
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<InventoryTag> saveInventoryTag(@RequestBody InventoryTag inventoryTag) {
        Long nextId = 0L;
        if (this.inventoryTags.size() != 0) {
            InventoryTag lastInventoryTag = this.inventoryTags.stream().skip(this.inventoryTags.size() - 1).findFirst().orElse(null);
            nextId = lastInventoryTag.getId() + 1;
        }

        inventoryTag.setId(nextId);
        this.inventoryTags.add(inventoryTag);
        return this.inventoryTags;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public List<InventoryTag> updateInventoryTag(@RequestBody InventoryTag inventoryTag) {
        InventoryTag modifiedInventoryTag = this.inventoryTags.stream().filter(i -> i.getId() == inventoryTag.getId()).findFirst().orElse(null);
        modifiedInventoryTag.setName(inventoryTag.getName());
        modifiedInventoryTag.setDescription(inventoryTag.getDescription());
        return this.inventoryTags;
    }

    @RequestMapping(value = "{/id}", method = RequestMethod.DELETE)
    public List<InventoryTag> deleteInventoryTag(@PathVariable Long id) {
        InventoryTag deleteInventoryTag = this.inventoryTags.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
        if (deleteInventoryTag != null) {
            this.inventoryTags.remove(deleteInventoryTag);
        }
        return this.inventoryTags;
    }

    List<InventoryTag> buildInventoryTags() {
        List<InventoryTag> inventoryTags = new ArrayList<>();

        InventoryTag tag1 = buildInventoryTag(1L, "MATMAN 1", "Inventory Management", "Used to identify items to be submitted to/removed from the MATMAN inventory management system", "01 Aug, 2018");
        InventoryTag tag2 = buildInventoryTag(2L, "MATMAN 2", "Inventory Management", "Used to identify items to be submitted to/removed from the MATMAN inventory management system", "02 Aug, 2018");
        InventoryTag tag3 = buildInventoryTag(3L, "MATMAN 3", "Inventory Management", "Used to identify items to be submitted to/removed from the MATMAN inventory management system", "03 Sep, 2018");
        InventoryTag tag4 = buildInventoryTag(4L, "MATMAN 4", "Inventory Management", "Used to identify items to be submitted to/removed from the MATMAN inventory management system", "01 Oct, 2018");
        InventoryTag tag5 = buildInventoryTag(5L, "MATMAN 5", "Inventory Management", "Used to identify items to be submitted to/removed from the MATMAN inventory management system", "01 Jan, 2019");

        inventoryTags.add(tag1);
        inventoryTags.add(tag2);
        inventoryTags.add(tag3);
        inventoryTags.add(tag4);
        inventoryTags.add(tag5);

        return inventoryTags;

    }

    InventoryTag buildInventoryTag(Long id, String name, String type, String description, String datetime) {
        InventoryTag inventoryTag = new InventoryTag();
        inventoryTag.setId(id);
        inventoryTag.setName(name);
        inventoryTag.setType(type);
        inventoryTag.setDescription(description);
        inventoryTag.setDatetime(datetime);
        return inventoryTag;
    }

}
