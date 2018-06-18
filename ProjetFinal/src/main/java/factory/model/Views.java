package factory.model;

public class Views {
	public static class ViewCommon {

	}

	public static class ViewFormation extends ViewCommon {

	}
	
	public static class ViewFormateur extends ViewCommon {

	}
	
	public static class ViewMatiere extends ViewCommon {

	}
	
	
	public static class ViewGestionnaire extends ViewCommon {

	}
	
	
	public static class ViewOrdinateur extends ViewCommon {
		
	}
	
	public static class ViewOrdinateurWithStagiaires extends ViewCommon {

	}
	
	
	public static class ViewFormationWithStagiaires extends ViewFormation {

	}
	
	public static class ViewFormateurWithFormations extends ViewFormation {

	}
	
	public static class ViewMatiereWithModules extends ViewFormation {

	}

	public static class ViewFormationWithModules extends ViewFormation{
		
	}
	
	public static class ViewStagiaireWithOrdinateurs extends ViewFormation{
		
	}
	
	
}
