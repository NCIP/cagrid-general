/**
*============================================================================
*  Copyright The Ohio State University Research Foundation, The University of Chicago - 
*	Argonne National Laboratory, Emory University, SemanticBits LLC, and 
*	Ekagra Software Technologies Ltd.
*
*  Distributed under the OSI-approved BSD 3-Clause License.
*  See http://ncip.github.com/cagrid-general/LICENSE.txt for details.
*============================================================================
**/
package org.cagrid.demo.photosharing.gallery.service.globus;

import org.cagrid.demo.photosharing.gallery.service.GalleryImpl;

import java.rmi.RemoteException;

/** 
 * DO NOT EDIT:  This class is autogenerated!
 *
 * This class implements each method in the portType of the service.  Each method call represented
 * in the port type will be then mapped into the unwrapped implementation which the user provides
 * in the PhotoSharingImpl class.  This class handles the boxing and unboxing of each method call
 * so that it can be correclty mapped in the unboxed interface that the developer has designed and 
 * has implemented.  Authorization callbacks are automatically made for each method based
 * on each methods authorization requirements.
 * 
 * @created by Introduce Toolkit version 1.3
 * 
 */
public class GalleryProviderImpl{
	
	GalleryImpl impl;
	
	public GalleryProviderImpl() throws RemoteException {
		impl = new GalleryImpl();
	}
	

    public org.cagrid.demo.photosharing.gallery.stubs.AddImageResponse addImage(org.cagrid.demo.photosharing.gallery.stubs.AddImageRequest params) throws RemoteException, org.cagrid.demo.photosharing.stubs.types.PhotoSharingException, org.cagrid.demo.photosharing.gallery.stubs.types.AuthorizationException {
    org.cagrid.demo.photosharing.gallery.stubs.AddImageResponse boxedResult = new org.cagrid.demo.photosharing.gallery.stubs.AddImageResponse();
    boxedResult.setImageDescription(impl.addImage(params.getImage().getImage()));
    return boxedResult;
  }

    public org.cagrid.demo.photosharing.gallery.stubs.ListImagesResponse listImages(org.cagrid.demo.photosharing.gallery.stubs.ListImagesRequest params) throws RemoteException, org.cagrid.demo.photosharing.gallery.stubs.types.AuthorizationException {
    org.cagrid.demo.photosharing.gallery.stubs.ListImagesResponse boxedResult = new org.cagrid.demo.photosharing.gallery.stubs.ListImagesResponse();
    boxedResult.setImageDescription(impl.listImages());
    return boxedResult;
  }

    public org.cagrid.demo.photosharing.gallery.stubs.GetImageResponse getImage(org.cagrid.demo.photosharing.gallery.stubs.GetImageRequest params) throws RemoteException, org.cagrid.demo.photosharing.gallery.stubs.types.AuthorizationException, org.cagrid.demo.photosharing.stubs.types.PhotoSharingException {
    org.cagrid.demo.photosharing.gallery.stubs.GetImageResponse boxedResult = new org.cagrid.demo.photosharing.gallery.stubs.GetImageResponse();
    boxedResult.setImage(impl.getImage(params.getImageDescription().getImageDescription()));
    return boxedResult;
  }

    public org.cagrid.demo.photosharing.gallery.stubs.GrantViewGalleryPrivilegesResponse grantViewGalleryPrivileges(org.cagrid.demo.photosharing.gallery.stubs.GrantViewGalleryPrivilegesRequest params) throws RemoteException, org.cagrid.demo.photosharing.gallery.stubs.types.AuthorizationException, org.cagrid.demo.photosharing.stubs.types.PhotoSharingException {
    org.cagrid.demo.photosharing.gallery.stubs.GrantViewGalleryPrivilegesResponse boxedResult = new org.cagrid.demo.photosharing.gallery.stubs.GrantViewGalleryPrivilegesResponse();
    impl.grantViewGalleryPrivileges(params.getUser().getUser());
    return boxedResult;
  }

    public org.cagrid.demo.photosharing.gallery.stubs.RevokeViewGalleryPrivilegesResponse revokeViewGalleryPrivileges(org.cagrid.demo.photosharing.gallery.stubs.RevokeViewGalleryPrivilegesRequest params) throws RemoteException, org.cagrid.demo.photosharing.gallery.stubs.types.AuthorizationException, org.cagrid.demo.photosharing.stubs.types.PhotoSharingException {
    org.cagrid.demo.photosharing.gallery.stubs.RevokeViewGalleryPrivilegesResponse boxedResult = new org.cagrid.demo.photosharing.gallery.stubs.RevokeViewGalleryPrivilegesResponse();
    impl.revokeViewGalleryPrivileges(params.getUser().getUser());
    return boxedResult;
  }

    public org.cagrid.demo.photosharing.gallery.stubs.GrantAddImagePrivilegesResponse grantAddImagePrivileges(org.cagrid.demo.photosharing.gallery.stubs.GrantAddImagePrivilegesRequest params) throws RemoteException, org.cagrid.demo.photosharing.gallery.stubs.types.AuthorizationException, org.cagrid.demo.photosharing.stubs.types.PhotoSharingException {
    org.cagrid.demo.photosharing.gallery.stubs.GrantAddImagePrivilegesResponse boxedResult = new org.cagrid.demo.photosharing.gallery.stubs.GrantAddImagePrivilegesResponse();
    impl.grantAddImagePrivileges(params.getUser().getUser());
    return boxedResult;
  }

    public org.cagrid.demo.photosharing.gallery.stubs.RevokeAddImagePrivilegesResponse revokeAddImagePrivileges(org.cagrid.demo.photosharing.gallery.stubs.RevokeAddImagePrivilegesRequest params) throws RemoteException, org.cagrid.demo.photosharing.gallery.stubs.types.AuthorizationException, org.cagrid.demo.photosharing.stubs.types.PhotoSharingException {
    org.cagrid.demo.photosharing.gallery.stubs.RevokeAddImagePrivilegesResponse boxedResult = new org.cagrid.demo.photosharing.gallery.stubs.RevokeAddImagePrivilegesResponse();
    impl.revokeAddImagePrivileges(params.getUser().getUser());
    return boxedResult;
  }

    public org.cagrid.demo.photosharing.gallery.stubs.GrantImageRetrievalPrivilegesResponse grantImageRetrievalPrivileges(org.cagrid.demo.photosharing.gallery.stubs.GrantImageRetrievalPrivilegesRequest params) throws RemoteException, org.cagrid.demo.photosharing.gallery.stubs.types.AuthorizationException, org.cagrid.demo.photosharing.stubs.types.PhotoSharingException {
    org.cagrid.demo.photosharing.gallery.stubs.GrantImageRetrievalPrivilegesResponse boxedResult = new org.cagrid.demo.photosharing.gallery.stubs.GrantImageRetrievalPrivilegesResponse();
    impl.grantImageRetrievalPrivileges(params.getImageDescription().getImageDescription(),params.getUser().getUser());
    return boxedResult;
  }

    public org.cagrid.demo.photosharing.gallery.stubs.RevokeImageRetrievalPrivilegesResponse revokeImageRetrievalPrivileges(org.cagrid.demo.photosharing.gallery.stubs.RevokeImageRetrievalPrivilegesRequest params) throws RemoteException, org.cagrid.demo.photosharing.gallery.stubs.types.AuthorizationException, org.cagrid.demo.photosharing.stubs.types.PhotoSharingException {
    org.cagrid.demo.photosharing.gallery.stubs.RevokeImageRetrievalPrivilegesResponse boxedResult = new org.cagrid.demo.photosharing.gallery.stubs.RevokeImageRetrievalPrivilegesResponse();
    impl.revokeImageRetrievalPrivileges(params.getImageDescription().getImageDescription(),params.getUser().getUser());
    return boxedResult;
  }

    public org.cagrid.demo.photosharing.gallery.stubs.GetGalleryNameResponse getGalleryName(org.cagrid.demo.photosharing.gallery.stubs.GetGalleryNameRequest params) throws RemoteException, org.cagrid.demo.photosharing.stubs.types.PhotoSharingException {
    org.cagrid.demo.photosharing.gallery.stubs.GetGalleryNameResponse boxedResult = new org.cagrid.demo.photosharing.gallery.stubs.GetGalleryNameResponse();
    boxedResult.setResponse(impl.getGalleryName());
    return boxedResult;
  }

    public org.cagrid.demo.photosharing.gallery.stubs.ListUsersWithAddPrivilegesResponse listUsersWithAddPrivileges(org.cagrid.demo.photosharing.gallery.stubs.ListUsersWithAddPrivilegesRequest params) throws RemoteException, org.cagrid.demo.photosharing.stubs.types.PhotoSharingException {
    org.cagrid.demo.photosharing.gallery.stubs.ListUsersWithAddPrivilegesResponse boxedResult = new org.cagrid.demo.photosharing.gallery.stubs.ListUsersWithAddPrivilegesResponse();
    boxedResult.setUser(impl.listUsersWithAddPrivileges());
    return boxedResult;
  }

    public org.cagrid.demo.photosharing.gallery.stubs.ListAllUsersWithViewPrivilegesResponse listAllUsersWithViewPrivileges(org.cagrid.demo.photosharing.gallery.stubs.ListAllUsersWithViewPrivilegesRequest params) throws RemoteException, org.cagrid.demo.photosharing.stubs.types.PhotoSharingException {
    org.cagrid.demo.photosharing.gallery.stubs.ListAllUsersWithViewPrivilegesResponse boxedResult = new org.cagrid.demo.photosharing.gallery.stubs.ListAllUsersWithViewPrivilegesResponse();
    boxedResult.setUser(impl.listAllUsersWithViewPrivileges());
    return boxedResult;
  }

}
