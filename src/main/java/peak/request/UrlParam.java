package vis.servlet.request;

import fj.data.Option;
import vis.servlet.HandlerContext;

/**
 * Part of the DSL for extracting named parameters from an url.
 * @author atlosm
 *
 */
public class UrlParam {

	private final String name;
	
	public UrlParam(final String name) {this.name = name;}
	
	public Option<String> get(HandlerContext context){
		return context.getRequest().getAttributeAsString(name);
	}
	
}
