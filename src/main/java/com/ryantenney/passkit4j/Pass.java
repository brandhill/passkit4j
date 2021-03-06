package com.ryantenney.passkit4j;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ryantenney.passkit4j.model.Barcode;
import com.ryantenney.passkit4j.model.Color;
import com.ryantenney.passkit4j.model.Location;
import com.ryantenney.passkit4j.model.PassInformation;

@Data
@NoArgsConstructor
@Accessors(chain=true, fluent=true)
public class Pass {

	@NonNull private String teamIdentifier;
	@NonNull private String passTypeIdentifier;
	@NonNull private String organizationName;
	@NonNull private String serialNumber;
	@NonNull private String description;

	@JsonProperty("formatVersion") private final int $formatVersion = 1;

	private Color backgroundColor;
	private Color foregroundColor;
	private Color labelColor;
	private String logoText;
	private Barcode barcode;
	@JsonInclude(Include.NON_DEFAULT) private boolean suppressStripShine = false;

	private String webServiceURL;
	private String authenticationToken;

	private List<Location> locations;
	private Date relevantDate;

	private List<String> associatedStoreIdentifiers;

	@JsonIgnore private PassInformation passInformation;
	@JsonIgnore private List<PassResource> files;

	public List<PassResource> files() {
		if (this.files == null) {
			return Collections.emptyList();
		}
		return this.files;
	}

	public Pass files(List<PassResource> values) {
		this.files = values;
		return this;
	}

	public Pass files(PassResource... values) {
		this.files = Arrays.asList(values);
		return this;
	}

	public List<Location> locations() {
		return this.locations;
	}

	public Pass locations(List<Location> values) {
		this.locations = values;
		return this;
	}

	public Pass locations(Location... values) {
		this.locations = Arrays.asList(values);
		return this;
	}

	public List<String> associatedStoreIdentifiers() {
		return this.associatedStoreIdentifiers;
	}

	public Pass associatedStoreIdentifiers(List<String> values) {
		this.associatedStoreIdentifiers = values;
		return this;
	}

	public Pass associatedStoreIdentifiers(String... values) {
		this.associatedStoreIdentifiers = Arrays.asList(values);
		return this;
	}

}
